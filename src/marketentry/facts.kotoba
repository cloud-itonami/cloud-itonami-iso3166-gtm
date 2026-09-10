(ns marketentry.facts
  "Guatemala (GTM) market-entry catalog.

  Every field traces to an independently-confirmed official source,
  fetched and read THIS session (2026-07-23). Guatemala's own primary
  procurement portals (guatecompras.gt) and its own business/company
  registrar (rgae.gob.gt) are BOTH behind an active Cloudflare
  bot-detection challenge on direct fetch this session (confirmed via
  response headers: `server: cloudflare`, `cf-mitigated: challenge` on
  guatecompras.gt; a Cloudflare `__cf_bm` challenge cookie + CSP
  referencing `challenges.cloudflare.com` on rgae.gob.gt) -- per this
  project's hard safety rule, this catalog did NOT attempt to bypass
  that challenge (no headless-browser rendering, no CAPTCHA-solving).
  Instead every citation below was fetched through the Internet
  Archive Wayback Machine, which had recent (2025-12-31 / 2026-04-08)
  clean captures of both sites' own primary-source content -- the
  sanctioned fallback, not a workaround of the block itself:

    - GUATECOMPRAS home page (own text, read directly): 'Es el
      Sistema de Información de Contrataciones y Adquisiciones del
      Estado, creado para brindar mayor transparencia a las compras
      públicas', administered by DIGAE ('Dirección General de
      Adquisiciones del Estado que pertenece al Viceministerio de
      Transparencia Fiscal y Adquisiciones del Estado del Ministerio
      de Finanzas Públicas'). Fetched via
      http://web.archive.org/web/20260408191958/https://www.guatecompras.gt/
      (live https://www.guatecompras.gt/ returned Cloudflare
      `cf-mitigated: challenge` on direct fetch this session).
    - RGAE ('Registro General de Adquisiciones del Estado') -- own
      text on the SAME Guatecompras home page (read directly): 'es
      la entidad encargada de habilitar a las personas individuales o
      jurídicas, nacionales o extranjeras, para que puedan participar
      como proveedores del Estado a través de un proceso de
      INSCRIPCIÓN Y PRECALIFICACIÓN' -- i.e. Guatemala's own portal
      names these as TWO DISTINCT registral gates, a fact this
      catalog's flagship check is built on, not assumed.
    - RGAE's own 'Marco Legal' page (own text, read directly) confirms
      the primary law: 'Decreto Número 57-92 del Congreso de la
      República -- Ley de Contrataciones del Estado y su Reglamento'
      (1992), plus its own amendment history list (own text): Decreto
      Número 9-2015, Decreto Número 46-2016, Decreto Número 16-2017,
      Decreto Numero 9-2024, among others. Fetched via
      http://web.archive.org/web/20251231151528/https://www.rgae.gob.gt/marco-legal-2/
      (live https://www.rgae.gob.gt/marco-legal-2 returned a Cloudflare
      challenge-cookie 403 on direct fetch this session).
    - The consolidated Ley de Contrataciones del Estado (Decreto
      57-92) + its Reglamento, hosted directly on RGAE's OWN site
      (own text, read directly via `pdftotext`) confirms: Art. 71
      ('El Registro General de Adquisiciones del Estado está adscrito
      al Ministerio de Finanzas Públicas ... verificará la capacidad
      financiera y técnica, así como la experiencia y especialidad
      necesarias para ser contratista o proveedor del Estado y
      relacionadas con los negocios con el Estado de que se trate' --
      i.e. RGAE's own statutory object explicitly ties verified
      CAPACITY to the SPECIFIC business the contractor undertakes,
      the ground-truth basis this catalog's flagship check formalizes);
      Art. 4 Bis (GUATECOMPRAS is administered by the Ministerio de
      Finanzas Públicas as 'órgano rector'); Art. 43 literal a)
      (Compra de Baja Cuantía: hasta Q.25,000.00, EXPRESSLY exempt
      from competitive-process requirements, reformado por Decreto
      46-2016 Art. 8); Art. 43 literal b) (Compra Directa: entre
      Q.25,000.01 y Q.90,000.00, vía oferta electrónica); Art. 38
      (Cotización: entre Q.90,000.01 y Q.900,000.00 para el Estado,
      reformado por Decretos 34-2001/73-2001/27-2009); Art. 17
      (Licitación Pública: por encima del monto del Art. 38, i.e.
      superior a Q.900,000.00). Fetched via
      http://web.archive.org/web/20260102121008/https://www.rgae.gob.gt/wp-content/uploads/2025/04/LEY-DE-CONTRATACIONES-DEL-ESTADO-Y-SU-REGLAMENTO-V2025FINAL.pdf
      (RGAE's own official hosting of the consolidated text; direct
      fetch of rgae.gob.gt blocked as above).
    - Acuerdo Gubernativo Número 133-2024 ('Requisitos, Trámites y
      Procedimientos de Inscripción, Precalificación y Otras
      Anotaciones Registrales ante el Registro General de
      Adquisiciones del Estado', reformado por Acuerdo Gubernativo
      208-2024, emitido bajo el Decreto Número 5-2021 -- Ley para la
      Simplificación de Requisitos y Trámites Administrativos) is the
      CURRENT RGAE registration regulation, own text confirms this is
      TWO SEPARATE Títulos: Título II 'Inscripción' (Arts. 4-11 --
      the base registration: Declaración Administrativa of no Art. 80
      LCE prohibitions, DPI/pasaporte vigente, for a Sociedad
      Mercantil also proof of inscription in the 'Registro Mercantil
      General de la República de Guatemala' -- Art. 9 literal b) --
      and 'Solvencia Fiscal emitida por la Superintendencia de
      Administración Tributaria' -- required across EVERY entity
      type, Arts. 5/7/8/9/10/17) and Título III 'Precalificación'
      (Arts. 12-16 -- a materially HEAVIER dossier: audited balance
      sheet, 'Certificación de la Integración del Capital de Trabajo
      Neto' from a Registro Tributario Unificado (RTU)-registered
      accountant, technical/experience track record). Fetched via
      http://web.archive.org/web/20260101224424/https://www.rgae.gob.gt/wp-content/uploads/2025/01/ACUERDO-GUBERNATIVO-133-2024-Requisitos-Tramites-y-Procedimientos-de-Inscripcion-Precalificacion-y-Otras-Anotaciones-Registral.pdf.
    - Código de Comercio, Decreto N.º 2-70 -- the SAME citation
      already established in this repo's own `src/statute/facts.cljc`
      (`gtm.codigo-comercio-decreto-2-70`, via the WIPO Lex mirror),
      NOT re-fetched or re-cited independently here; reused for the
      Registro Mercantil GENERAL requirement AG 133-2024 Art. 9
      literal b) points to. Unlike Honduras's `marketentry.facts`
      (which reuses its own Código de Comercio citation for a
      MANDATORY-PERMANENT-FOREIGN-REPRESENTATIVE requirement, Art.
      308 numeral III), this catalog deliberately carries NO `rep-*`
      sub-schema: an attempt this session to re-open the WIPO Lex PDF
      already cited in `statute.facts` (`gt010es.pdf`) found that
      WIPO Lex's own URL structure has since moved that path to a
      client-rendered '/wipolex/en/legislation/details/2018' page that
      did not serve a direct article citation this session, and this
      catalog does not guess an article number from memory -- an
      honest scoping gap, not a fabricated citation.
    - SAT (Superintendencia de Administración Tributaria) -- BOTH
      `sat.gob.gt`/`www.sat.gob.gt` (redirect-chain only, no
      substantive page ever crawled by the Wayback Machine in any
      capture 2020-2026 per its own CDX index) AND
      `portal.sat.gob.gt` (every 2025-2026 capture in the Wayback
      Machine's own CDX index is itself a Cloudflare
      `challenge-platform` artifact, meaning even the Internet
      Archive's own crawler was challenge-blocked) are UNREACHABLE
      this session, live or archived. This catalog does NOT claim to
      have independently browsed SAT's own site, live or archived,
      and does NOT cite a specific SAT-issued NIT-registration article
      number as a result -- RTU (Registro Tributario Unificado) and
      'Solvencia Fiscal' are instead cited only at the level AG
      133-2024's OWN text (an RGAE-hosted source independently
      fetched this session) states them, an honest gap, not a
      fabricated one, mirroring the fleet's own discipline (e.g.
      Honduras's `marketentry.facts` similarly declining to pin a
      specific Código Tributario article for its RTN requirement).

  Guatemala genuinely has NO enacted data-protection law as of this
  tick -- this repo's own `src/statute/facts.cljc` already disclosed
  this (confirmed via WebSearch in a prior session: as of 2025 only
  three competing legislative INITIATIVES exist, none enacted). This
  catalog does not fabricate a data-protection-registration
  requirement either, and does not add a second, contradicting
  statement about it -- it simply has no entry that depends on one.

  A jurisdiction not in `catalog` has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> requirement map. `:required-evidence` mirrors the fleet's
  generic intake/portal-registration/filing evidence set, scoped to
  the DISTINCT regulatory-authority-level items this session
  independently confirmed. `:precalificacion-tiers` grounds this
  vertical's FLAGSHIP governor check
  (`precalificacion-ceiling-mismatch?` in `marketentry.registry`) -- a
  REGISTRATION-TIER-VS-CONTRACT-VALUE CEILING check, a check SHAPE
  genuinely different from every prior sibling: not a
  territorial-jurisdiction lookup (Honduras's Cámara de Comercio
  department mismatch), not a same-branch eligibility/threshold-claim
  recompute (Nicaragua's Contratación Menor certificate boolean,
  Andorra's direct-contracting-claim boolean), not a sector-
  conditional constitutional restriction (Panama's Art. 288
  retail-trade check), not a data-processing-scope mismatch (Costa
  Rica's PRODHAB check), but a verification that an engagement's own,
  ALREADY-ON-FILE RGAE registration tier (mere Título II Inscripción
  vs the materially heavier Título III Precalificación dossier)
  actually covers the STATUTORY VALUE CEILING of the specific
  procurement modality (Compra de Baja Cuantía / Compra Directa /
  Cotización / Licitación Pública, LCE Arts. 17/38/43) the engagement
  itself declares -- grounded directly in RGAE's own statutory object
  (LCE Art. 71: the Registry verifies capacity 'relacionadas con los
  negocios con el Estado de que se trate')."
  {"GTM"
   {:name "Republic of Guatemala"
    :owner-authority "Dirección General de Adquisiciones del Estado (DIGAE), Viceministerio de Transparencia Fiscal y Adquisiciones del Estado, Ministerio de Finanzas Públicas -- operando el Registro General de Adquisiciones del Estado (RGAE)"
    :legal-basis "Ley de Contrataciones del Estado, Decreto Número 57-92 del Congreso de la República (1992), Arts. 1 (ámbito), 4 Bis (GUATECOMPRAS), 17/38/43 (umbrales de modalidad) y 71-79 (RGAE); reformada por, entre otros, los Decretos Número 9-2015, 46-2016, 16-2017 y 9-2024 (propia lista de reformas de la propia página 'Marco Legal' de RGAE, texto propio leído directamente); reglamento vigente de inscripción/precalificación: Acuerdo Gubernativo Número 133-2024, reformado por el Acuerdo Gubernativo Número 208-2024"
    :national-spec "GUATECOMPRAS -- Sistema de Información de Contrataciones y Adquisiciones del Estado (www.guatecompras.gt), creado por/regulado en la Ley de Contrataciones del Estado Art. 4 Bis, administrado por el Ministerio de Finanzas Públicas como órgano rector; uso público, irrestricto y gratuito para consulta (texto propio del Art. 4 Bis). El Registro General de Adquisiciones del Estado (RGAE, LCE Arts. 71-79) es la entidad que habilita contratistas/proveedores mediante DOS trámites registrales distintos -- Inscripción (Título II AG 133-2024) y Precalificación (Título III AG 133-2024) -- texto propio de la página de inicio de GUATECOMPRAS."
    :provenance "https://www.guatecompras.gt/ (vía http://web.archive.org/web/20260408191958/https://www.guatecompras.gt/ -- fetch directo bloqueado por desafío Cloudflare este session) ; https://www.rgae.gob.gt/marco-legal-2/ (vía http://web.archive.org/web/20251231151528/https://www.rgae.gob.gt/marco-legal-2/) ; https://www.rgae.gob.gt/wp-content/uploads/2025/04/LEY-DE-CONTRATACIONES-DEL-ESTADO-Y-SU-REGLAMENTO-V2025FINAL.pdf (vía http://web.archive.org/web/20260102121008/...) ; https://www.rgae.gob.gt/wp-content/uploads/2025/01/ACUERDO-GUBERNATIVO-133-2024-Requisitos-Tramites-y-Procedimientos-de-Inscripcion-Precalificacion-y-Otras-Anotaciones-Registral.pdf (vía http://web.archive.org/web/20260101224424/...)"
    :required-evidence ["Patente de Comercio / inscripción vigente ante el Registro Mercantil General de la República de Guatemala (Código de Comercio, Decreto N.º 2-70 -- LA MISMA citación ya establecida en statute.facts/gtm.codigo-comercio-decreto-2-70; referenciada por AG 133-2024 Art. 9 literal b)"
                         "RGAE Constancia de Inscripción (Título II, Arts. 4-11 AG 133-2024) -- Declaración Administrativa de no estar comprendido en las prohibiciones del Art. 80 LCE, DPI/pasaporte vigente"
                         "SAT Solvencia Fiscal (constancia de solvencia fiscal, requerida en TODOS los tipos de entidad -- AG 133-2024 Arts. 5/7/8/9/10/17)"
                         "RGAE Constancia de Precalificación (Título III, Arts. 12-16 AG 133-2024) -- exigida SOLO cuando el valor declarado del contrato exige Cotización o Licitación Pública (LCE Arts. 38/17, > Q.90,000.00)"
                         "Publicación del evento en GUATECOMPRAS (NOG/NPG, Sistema de Información de Contrataciones y Adquisiciones del Estado, LCE Art. 4 Bis)"]
    :corporate-number-owner-authority "Superintendencia de Administración Tributaria (SAT)"
    :corporate-number-legal-basis "RTU (Registro Tributario Unificado) y Solvencia Fiscal -- referenciados únicamente al nivel que el propio texto de AG 133-2024 los cita (contador público y auditor 'que figure en el Registro Tributario Unificado -RTU-', Arts. 14/15; 'Solvencia Fiscal emitida por la Superintendencia de Administración Tributaria', Arts. 5/7/8/9/10/17); ningún decreto orgánico de la SAT ni artículo específico de inscripción obligatoria de NIT fue verificado de forma independiente en esta sesión -- brecha honesta, no fabricada"
    :corporate-number-provenance "sat.gob.gt / www.sat.gob.gt / portal.sat.gob.gt UNREACHABLE en esta sesión -- fetch directo devolvió bloqueo Cloudflare (portal.sat.gob.gt) o solo redirecciones (sat.gob.gt), y la búsqueda en el índice CDX de Wayback Machine (2020-2026) no encontró NINGUNA captura con contenido sustantivo (solo redirecciones 301/302 o el propio artefacto challenge-platform de Cloudflare) -- disclosed, not concealed; citado en su lugar vía AG 133-2024 (ver :legal-basis arriba)"
    ;; flagship spec-basis -- the STATUTORY value ceiling ladder (LCE
    ;; Arts. 17, 38, 43), independently re-derivable from a contract's
    ;; own declared value, cross-referenced against whether the
    ;; engagement's ON-FILE RGAE registration tier (Inscripción-only
    ;; vs Precalificado) actually covers it.
    :precalificacion-ceiling-owner-authority "Registro General de Adquisiciones del Estado (RGAE), adscrito al Ministerio de Finanzas Públicas (Ley de Contrataciones del Estado, Decreto 57-92, Arts. 71-79)"
    :precalificacion-ceiling-legal-basis "LCE Art. 43 literal a) (reformado por Decreto 46-2016 Art. 8): Compra de Baja Cuantía hasta Q.25,000.00, EXPRESAMENTE exceptuada de los procesos competitivos. LCE Art. 43 literal b): Compra Directa, entre Q.25,000.01 y Q.90,000.00, vía oferta electrónica. LCE Art. 38 (reformado por Decretos 34-2001/73-2001/27-2009): Cotización, entre Q.90,000.01 y Q.900,000.00 para el Estado. LCE Art. 17 (remite al Art. 38): Licitación Pública, por encima de Q.900,000.00. AG 133-2024 Título II vs Título III: la Precalificación (dossier financiero/técnico más pesado, Arts. 12-16) es un trámite DISTINTO y ADICIONAL a la Inscripción base (Arts. 4-11), texto propio confirma que la Precalificación es la que RGAE exige para participar en las modalidades competitivas (Cotización/Licitación Pública)."
    :precalificacion-tiers [{:tier :baja-cuantia :max-value-gtq 25000.0 :requires-precalificacion? false :basis "LCE Art. 43 literal a)"}
                            {:tier :compra-directa :max-value-gtq 90000.0 :requires-precalificacion? false :basis "LCE Art. 43 literal b)"}
                            {:tier :cotizacion :max-value-gtq 900000.0 :requires-precalificacion? true :basis "LCE Art. 38"}
                            {:tier :licitacion-publica :max-value-gtq nil :requires-precalificacion? true :basis "LCE Art. 17 (remite al Art. 38)"}]
    :precalificacion-ceiling-provenance "https://www.rgae.gob.gt/wp-content/uploads/2025/04/LEY-DE-CONTRATACIONES-DEL-ESTADO-Y-SU-REGLAMENTO-V2025FINAL.pdf (vía http://web.archive.org/web/20260102121008/...) ; https://www.rgae.gob.gt/wp-content/uploads/2025/01/ACUERDO-GUBERNATIVO-133-2024-Requisitos-Tramites-y-Procedimientos-de-Inscripcion-Precalificacion-y-Otras-Anotaciones-Registral.pdf (vía http://web.archive.org/web/20260101224424/...)"}})

(defn spec-basis
  "The jurisdiction's requirement map, or nil -- nil means NO
  spec-basis, and the governor must hold any proposal that tries to
  assess or file on it."
  [iso3]
  (get catalog iso3))

(defn coverage
  "Honest coverage report: how many of the requested jurisdictions
  actually have a spec-basis entry. Never report a missing
  jurisdiction as covered."
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-gtm marketentry.facts R0: " (count catalog)
                 " jurisdiction seeded with an official spec-basis. "
                 "This is a starting catalog for market-entry navigation, "
                 "not a survey of all ~194 jurisdictions -- extend "
                 "`marketentry.facts/catalog`, never fabricate a "
                 "jurisdiction's requirements.")})))

(defn required-evidence-satisfied?
  "Does `submitted` (a set/coll of evidence keywords or strings)
  satisfy every evidence item listed for `iso3`? Missing spec-basis ->
  never satisfied."
  [iso3 submitted]
  (when-let [{:keys [required-evidence]} (spec-basis iso3)]
    (let [need (count required-evidence)
          have (count (filter (set submitted) required-evidence))]
      (= need have))))

(defn evidence-checklist [iso3] (:required-evidence (spec-basis iso3) []))

(defn corporate-number-spec-basis
  "The jurisdiction's corporate-number / tax-id regime, or nil."
  [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:corporate-number-owner-authority sb)
      (select-keys sb [:corporate-number-owner-authority
                        :corporate-number-legal-basis
                        :corporate-number-provenance]))))

(defn precalificacion-ceiling-spec-basis
  "Spec-basis for the flagship RGAE-registration-tier-vs-contract-
  value-ceiling check -- used by the governor's flagship check to cite
  an official basis (and the confirmed value-tier ladder) rather than
  assert a mismatch bare."
  [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:precalificacion-ceiling-owner-authority sb)
      (select-keys sb [:precalificacion-ceiling-owner-authority
                        :precalificacion-ceiling-legal-basis
                        :precalificacion-tiers
                        :precalificacion-ceiling-provenance]))))

(defn required-tier
  "The statutory procurement-modality tier for `contract-value-gtq`
  under `iso3`'s own `:precalificacion-tiers` ladder -- or `nil` when
  the jurisdiction has no spec-basis at all. NEVER guesses a tier for
  an unlisted jurisdiction. The ladder is declared in ascending
  `:max-value-gtq` order (`nil` meaning unbounded, always last), so
  the first entry whose ceiling the value does not exceed is the
  correct tier -- no platform-specific infinity sentinel needed."
  [iso3 contract-value-gtq]
  (when-let [{:keys [precalificacion-tiers]} (precalificacion-ceiling-spec-basis iso3)]
    (:tier (first (filter (fn [{:keys [max-value-gtq]}]
                            (or (nil? max-value-gtq) (<= contract-value-gtq max-value-gtq)))
                          precalificacion-tiers)))))

(defn precalificacion-required?
  "Does `iso3`'s own tier ladder require RGAE Precalificación (Título
  III) for a `tier` (e.g. `:cotizacion`), as opposed to the lighter
  Inscripción-only (Título II) regime that covers Compra de Baja
  Cuantía / Compra Directa? Unlisted tier or jurisdiction -> false,
  never assumed required nor assumed exempt."
  [iso3 tier]
  (boolean
   (when-let [{:keys [precalificacion-tiers]} (precalificacion-ceiling-spec-basis iso3)]
     (:requires-precalificacion? (first (filter #(= (:tier %) tier) precalificacion-tiers))))))
