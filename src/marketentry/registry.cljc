(ns marketentry.registry
  "Pure-function market-entry filing-draft + filing-submit record
  construction -- an append-only market-entry book-of-record draft.

  Like every sibling actor's registry, there is no single international
  reference-number standard for a public-procurement market-entry
  filing -- Guatemala assigns its own formats (RGAE Constancia de
  Inscripción/Precalificación numbers, SAT NIT/RTU numbers, GUATECOMPRAS
  NOG/NPG numbers each have their own real formats this actor does not
  reproduce). This namespace does NOT invent one; it builds a
  jurisdiction-scoped sequence number and validates the record's
  required fields, the same honest, non-fabricating discipline
  `marketentry.facts` uses.

  `engagement-fee-matches-claim?` is an HONEST reapplication of the
  SAME ground-truth-recompute DISCIPLINE sibling actors use (verify a
  claimed monetary total against the entity's own recorded quantity x
  unit fields), reapplied to a market-entry engagement fee line.

  `precalificacion-ceiling-mismatch?` is the FLAGSHIP check for this
  vertical -- see `marketentry.facts`'s namespace docstring for the
  full grounding (Ley de Contrataciones del Estado, Decreto 57-92,
  Arts. 17/38/43/71-79; Acuerdo Gubernativo 133-2024 Títulos II/III).
  It INDEPENDENTLY re-derives the statutory procurement-modality tier
  an engagement's own declared `:contract-value-gtq` falls into (Compra
  de Baja Cuantía / Compra Directa / Cotización / Licitación Pública),
  and verifies whether the engagement's own, ALREADY-ON-FILE
  `:rgae-status` (mere Título II Inscripción vs the materially heavier
  Título III Precalificación dossier) actually covers that tier -- a
  REGISTRATION-TIER-VS-CONTRACT-VALUE CEILING check, not a boolean-
  presence check, not a territorial-jurisdiction lookup, not a
  same-branch eligibility-claim recompute.

  This namespace is pure data + pure functions -- no I/O, no network
  call to any real procurement portal (GUATECOMPRAS included). It
  builds the RECORD an operator would keep, not the act of submitting
  a portal registration itself (that is `marketentry.operation`'s
  `:filing/submit`, always human-gated -- see README Actuation)."
  (:require [clojure.string :as str]
            [marketentry.facts :as facts]))

(defn- unsigned-certificate
  "Every certificate this actor produces is UNSIGNED -- signature is
  the market-entry operator's act, not this actor's."
  [kind subject record-id]
  {"@context" ["https://www.w3.org/ns/credentials/v2"]
   "type" ["VerifiableCredential" kind]
   "credentialSubject" {"id" subject "record" record-id}
   "proof" nil
   "issued_by_registry" false
   "status" "draft-unsigned"})

(defn- zero-pad [n w]
  (let [s (str n)]
    (str (apply str (repeat (max 0 (- w (count s))) "0")) s)))

(defn compute-engagement-fee
  "The ground-truth engagement fee for `engagement`'s own `:base-fee`
  and `:monitoring-months` x `:monthly-rate` -- a single flat
  base + months x rate calculation, not a full pricing engine."
  [{:keys [base-fee monthly-rate monitoring-months]}]
  (+ (double base-fee)
     (* (double monthly-rate) (double monitoring-months))))

(defn engagement-fee-matches-claim?
  "Does `engagement`'s own `:claimed-fee` equal the independently
  recomputed `compute-engagement-fee`?"
  [{:keys [claimed-fee] :as engagement}]
  (== (double claimed-fee) (compute-engagement-fee engagement)))

(defn precalificacion-ceiling-mismatch?
  "FLAGSHIP check. INDEPENDENTLY re-derives the statutory procurement-
  modality tier `engagement`'s own claimed `:contract-value-gtq` falls
  into (per `marketentry.facts/required-tier`, LCE Arts. 17/38/43),
  and verifies whether that tier actually requires RGAE Precalificación
  (Título III AG 133-2024) per
  `marketentry.facts/precalificacion-required?`. Returns true (mismatch
  -- a violation) when the tier requires Precalificación but the
  engagement's own on-file `:rgae-status` is only `:inscripcion` (Título
  II, the lighter base registration) -- never silently assumes a mere
  Inscripción covers a Cotización/Licitación Pública-tier engagement."
  [{:keys [jurisdiction contract-value-gtq rgae-status]}]
  (let [tier (facts/required-tier jurisdiction contract-value-gtq)]
    (boolean
     (and tier
          (facts/precalificacion-required? jurisdiction tier)
          (not= rgae-status :precalificado)))))

(defn register-draft
  "Validate + construct the FILING-DRAFT registration DRAFT -- the
  market-entry operator's own act of preparing a portal registration
  package. Pure function -- does not touch any real procurement
  portal (GUATECOMPRAS included)."
  [engagement-id jurisdiction sequence]
  (when-not (and engagement-id (not= engagement-id ""))
    (throw (ex-info "draft: engagement_id required" {})))
  (when-not (and jurisdiction (not= jurisdiction ""))
    (throw (ex-info "draft: jurisdiction required" {})))
  (when (< sequence 0)
    (throw (ex-info "draft: sequence must be >= 0" {})))
  (let [draft-number (str (str/upper-case jurisdiction) "-DFT-" (zero-pad sequence 6))
        record {"record_id" draft-number
                "kind" "filing-draft"
                "engagement_id" engagement-id
                "jurisdiction" jurisdiction
                "immutable" true}]
    {"record" record "draft_number" draft-number
     "certificate" (unsigned-certificate "FilingDraft" draft-number draft-number)}))

(defn register-submit
  "Validate + construct the FILING-SUBMIT registration DRAFT -- the
  market-entry operator's own act of actually submitting a portal
  registration (always human-gated upstream)."
  [engagement-id jurisdiction sequence]
  (when-not (and engagement-id (not= engagement-id ""))
    (throw (ex-info "submit: engagement_id required" {})))
  (when-not (and jurisdiction (not= jurisdiction ""))
    (throw (ex-info "submit: jurisdiction required" {})))
  (when (< sequence 0)
    (throw (ex-info "submit: sequence must be >= 0" {})))
  (let [submit-number (str (str/upper-case jurisdiction) "-SUB-" (zero-pad sequence 6))
        record {"record_id" submit-number
                "kind" "filing-submit"
                "engagement_id" engagement-id
                "jurisdiction" jurisdiction
                "immutable" true}]
    {"record" record "submit_number" submit-number
     "certificate" (unsigned-certificate "FilingSubmit" submit-number submit-number)}))

(defn append [history result]
  (conj (vec history) (get result "record")))
