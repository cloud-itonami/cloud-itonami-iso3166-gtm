# cloud-itonami-iso3166-gtm

Open ISO 3166 Blueprint for **GTM**: Republic of Guatemala -- **`:implemented`**.

This repository designs **and implements** a forkable OSS business for
an independent public-sector market-entry consultant: an already-
incorporated operator (e.g. a `cloud-itonami-cofog-{code}`,
`cloud-itonami-isco-{code}`, `cloud-itonami-unspsc-{segment}` or
`cloud-itonami-{ISIC}` blueprint fork) gets a **MarketEntry-LLM**
Compliance Advisor + independent **Market-Entry Compliance Governor**
to navigate public-procurement registration (GUATECOMPRAS / RGAE),
local business/tax registration (Registro Mercantil General, SAT
Solvencia Fiscal), and RGAE's own Inscripción/Precalificación regime
in Guatemala, so the operator can win and service a government
contract without hiring a full in-house compliance department.

## Checks

Five checks, in priority order, evaluated by `marketentry.governor` on
every `MarketEntry-LLM` proposal. The first four are HARD violations a
human approver cannot override; double-actuation guards are counted
separately. The confidence/actuation gate (item 5) is SOFT -- but see
Actuation below, `:filing/draft`/`:filing/submit` never auto-commit
regardless.

| # | Check | Grounds | Source |
|---|---|---|---|
| 1 | **Spec-basis** -- a `:jurisdiction/assess`/`:filing/draft`/`:filing/submit` proposal must cite an official source, never an invented one | `marketentry.facts/spec-basis` | rgae.gob.gt, guatecompras.gt |
| 2 | **Evidence incomplete** -- for draft/submit, the jurisdiction's full required-evidence checklist must be on file: (a) Registro Mercantil General inscription, (b) RGAE Inscripción, (c) SAT Solvencia Fiscal, (d) RGAE Precalificación, (e) GUATECOMPRAS event publication | `marketentry.facts/required-evidence-satisfied?` | Código de Comercio (Decreto N.º 2-70) Art. 9 AG 133-2024; Ley de Contrataciones del Estado (Decreto 57-92) Arts. 4 Bis, 71-79; Acuerdo Gubernativo 133-2024 |
| 3 | **Precalificación ceiling mismatch** (flagship, value-conditional) -- for submit, INDEPENDENTLY verify whether the engagement's own claimed `:contract-value-gtq` requires RGAE Precalificación (Cotización/Licitación Pública tier); fires ONLY on a genuine ceiling breach, NEVER for a Precalificado engagement nor for a genuinely low-value engagement Inscripción alone legitimately covers -- not a blanket rule against any `:rgae-status` | `marketentry.governor/precalificacion-ceiling-mismatch-violations` | Ley de Contrataciones del Estado (Decreto 57-92) Arts. 17/38/43/71 -- Guatemala's own statutory procurement-modality value ladder, independently confirmed against RGAE's own Acuerdo Gubernativo 133-2024 Títulos II (Inscripción) / III (Precalificación) |
| 4 | **Engagement fee mismatch** -- for submit, independently recompute `claimed-fee = base-fee + monthly-rate x monitoring-months` | `marketentry.registry/engagement-fee-matches-claim?` | ground-truth recompute (fleet-standard discipline) |
| 5 | **Confidence floor / actuation gate** (SOFT) -- LLM confidence below 0.6, or the op is `:filing/draft`/`:filing/submit` -> escalate to human | `marketentry.governor/check` | this vertical's own Trust Controls (`docs/business-model.md`) |

Two further double-actuation guards (`already-drafted`,
`already-submitted`) refuse to draft or submit the SAME engagement
twice, enforced off dedicated `:drafted?`/`:submitted?` booleans, never
a `:status` value.

Check 3 is deliberately **value-conditional, not a blanket rule**:
`test/marketentry/governor_contract_test.clj`'s
`precalificacion-ceiling-mismatch-does-not-fire-for-a-correct-match`
proves a Q.500,000 (Cotización-tier) engagement that is genuinely
Precalificado proceeds through the ordinary escalate-then-approve path
with no HARD hold, while
`precalificacion-ceiling-mismatch-is-held-and-unoverridable` proves the
SAME Q.500,000 value claimed under mere Inscripción (no Precalificación
on file) instead is an un-overridable HARD hold. Two independent,
contrasting fixtures (`eng-4`, `eng-5`) in
`marketentry.store/demo-data` exercise both branches; a third (`eng-6`,
a genuinely low-value Q.60,000 Compra Directa-tier engagement claimed
under mere Inscripción) proves the check does not false-positive on a
value the law itself exempts from Precalificación (LCE Art. 43).

**Guatemala's own procurement law sets a four-tier statutory value
ladder for its acquisition modalities, a structural fact this
repository confirmed from the primary law text itself, not merely
assumed:** Ley de Contrataciones del Estado (Decreto N.º 57-92 --
Art. 43 literal a, reformado por Decreto 46-2016 Art. 8) exempts
Compra de Baja Cuantía (up to Q.25,000.00) from competitive-process
requirements entirely; Art. 43 literal b) sets Compra Directa between
Q.25,000.01 and Q.90,000.00 (via oferta electrónica, no Precalificación
needed); Art. 38 sets Cotización between Q.90,000.01 and Q.900,000.00;
Art. 17 (remitting to Art. 38) requires Licitación Pública above
Q.900,000.00. RGAE's own registration regulation, Acuerdo Gubernativo
133-2024 (reformado por Acuerdo Gubernativo 208-2024), splits its own
registral gates into Título II Inscripción (Arts. 4-11 -- the base
registration) and a materially heavier Título III Precalificación
(Arts. 12-16 -- audited balance sheet, Capital de Trabajo Neto
certification from an RTU-registered accountant, technical/experience
track record), and this catalog independently confirmed the two are
DISTINCT registral gates directly from GUATECOMPRAS's own home-page
text: RGAE 'es la entidad encargada de habilitar a las personas
individuales o jurídicas ... a través de un proceso de INSCRIPCIÓN Y
PRECALIFICACIÓN'.
`marketentry.facts/required-tier` + `marketentry.facts/precalificacion-required?`
expose ONLY this independently-confirmed value ladder -- see
`test/marketentry/facts_test.clj`'s
`required-tier-follows-the-statutory-ladder`.

**Guatemala's Registro Mercantil is, by contrast with Honduras's
decentralized department-by-department chamber system, explicitly a
SINGLE national registry:** AG 133-2024 Art. 9 literal b) (own text)
requires a Sociedad Mercantil to present 'Documentación que acredite
estar inscrito ante el **Registro Mercantil General** de la República
de Guatemala' -- i.e. one GENERAL registry, not a per-department one.
This repo's `marketentry.facts` reuses the SAME Código de Comercio
(Decreto N.º 2-70) citation already established in this repo's own
`src/statute/facts.cljc` for that requirement -- never a second,
different one -- and deliberately does NOT include a `rep-*`
(mandatory-foreign-representative) sub-schema the way Honduras's
`marketentry.facts` does: an attempt this session to re-open the WIPO
Lex PDF already cited in `statute.facts` found that WIPO Lex's own URL
structure has since moved that path to a client-rendered details page
that did not serve a direct article citation this session, and this
catalog does not guess an article number from memory -- an honest
scoping gap, not a fabricated citation.

## Actuation

**Drafting a real GUATECOMPRAS filing / portal registration and
submitting a real filing are never autonomous, at any phase, by
construction.** Two independent layers enforce this:

- `marketentry.governor`'s `high-stakes` set
  (`#{:actuation/draft-filing :actuation/submit-filing}`) always
  escalates, regardless of confidence.
- `marketentry.phase`'s phase table (`phase 0` through `phase 3`)
  never puts `:filing/draft` or `:filing/submit` in any phase's
  `:auto` set -- see `marketentry.phase`'s own docstring and
  `test/marketentry/phase_test.clj`'s `filing-submit-never-auto`, plus
  `test/marketentry/governor_contract_test.clj`'s
  `filing-draft-and-submit-never-auto-commit`.

The actor may intake an engagement, assess a jurisdiction and draft a
recommendation; a human market-entry operator is always the one who
actually files a draft or a submission. Grounded directly in this
blueprint's own [`docs/business-model.md`](docs/business-model.md) and
`marketentry.governor`'s own namespace docstring, which names this
vertical's Trust Controls verbatim: "any actual portal registration or
filing submission requires Market-Entry Compliance Governor clearance
and always escalates to human sign-off"; "a false or fabricated
regulatory-requirement claim is a HARD hold". `:filing/draft` and
`:filing/submit` apply SEQUENTIALLY to the SAME engagement record
(draft first, submit later) -- matching every sibling
`market-entry-compliance-governor` actor's own sequential shape.

## No robotics premise — digital/data service exemption

Market-entry and procurement-compliance navigation is a pure data/software
service with no physical-domain work (portal registration, document
checklists, regulatory-change monitoring) — the same exemption class as
`cloud-itonami-6310` (HR SaaS replacement) and `cloud-itonami-gtin-*`.
`blueprint.edn` sets `:itonami.blueprint/robotics false` and
`:required-technologies` lists only real capabilities (`:identity`,
`:forms`, `:dmn`, `:bpmn`, `:audit-ledger`), no `:robotics`.

## Core Contract

```text
operator intake + prior filing history
        |
        v
Compliance Advisor -> Market-Entry Compliance Governor -> filing draft, or human sign-off
        |
        v
gated portal registration / filing submission + audit ledger
```

No automated proposal can submit a portal registration or filing the
governor refuses, suppress a compliance record, or claim a legal/tax
conclusion the governor has not cleared. `:filing/submit` is never in any
phase's `:auto` set — it always requires human sign-off (mirrors
`cloud-itonami-M6910`'s `filing-submit-never-auto-at-any-phase`
invariant).

## What this is NOT

- **Not the government of Guatemala.** See
  [`docs/business-model.md`](docs/business-model.md) for the boundary with
  `com-etzhayyim-ooyake` (read-only civic mirror), `matsurigoto` (sovereign
  statecraft), `com-etzhayyim-toritsugi` (individual citizen concierge),
  `legal-entity.etzhayyim.com` (read-only data aggregation), and
  `cloud-itonami-M6910` (company incorporation — a different regulatory
  phase this blueprint assumes is already complete).
- **Not legal or tax advice.** Every regulatory claim must cite the
  official source and route final filings to Guatemalan-licensed counsel
  or a registered agent where the law requires licensed representation.
- **Not a data-protection compliance service.** Guatemala has NO enacted
  comprehensive data-protection law as of this catalog's own `statute.facts`
  disclosure (only competing legislative initiatives, none enacted) —
  this repo does not fabricate a data-protection-registration requirement
  to fill that gap.

## Capability layer

Resolves via [`kotoba-lang/iso3166`](https://github.com/kotoba-lang/iso3166)
(ISO 3166 `GTM`). Required capabilities:

- :identity
- :forms
- :dmn
- :bpmn
- :audit-ledger

See [`docs/business-model.md`](docs/business-model.md) and
[`docs/operator-guide.md`](docs/operator-guide.md).

## Run

```bash
clojure -M:dev:run     # walk a clean intake -> assess -> draft -> submit lifecycle, plus HARD-hold scenarios (precalificación ceiling mismatch included)
clojure -M:dev:test    # governor contract · phase invariants · store parity · registry conformance · facts coverage
clojure -M:lint        # clj-kondo (errors fail; CI mirrors this)
```

## License

AGPL-3.0-or-later.

## Market-entry / statute catalogs

Governed public-sector market-entry compliance actor, same architecture
as the other `cloud-itonami-iso3166-*` siblings:

- `src/marketentry/{facts,governor,phase,sim,operation,registry,store,
  marketentryllm}.cljc` -- the actor. `facts.cljc` cites the Ley de
  Contrataciones del Estado (Decreto Número 57-92, own text confirms
  RGAE's statutory object and its own Arts. 17/38/43 value ladder),
  GUATECOMPRAS (Art. 4 Bis, administered by the Ministerio de Finanzas
  Públicas as órgano rector), RGAE's own Acuerdo Gubernativo 133-2024
  (Inscripción/Precalificación regime, own text read directly via
  `pdftotext`), and — reusing the SAME Código de Comercio (Decreto N.º
  2-70) citation already established in this repo's own
  `src/statute/facts.cljc`, never a second, different one — the
  Registro Mercantil General requirement. `governor.cljc`'s flagship
  check independently verifies whether an engagement's claimed
  contract value requires RGAE Precalificación while only Inscripción
  is on file -- a check SHAPE genuinely different from siblings whose
  flagship check is a territorial-jurisdiction lookup (Honduras's
  Cámara de Comercio department mismatch), a same-branch
  eligibility-claim recompute (Nicaragua, Andorra), or a sector-
  conditional constitutional restriction (Panama's Art. 288
  retail-trade check): this one is a REGISTRATION-TIER-VS-CONTRACT-
  VALUE CEILING test, grounded in RGAE's own statutory object (LCE
  Art. 71: the Registry verifies capacity "relacionadas con los
  negocios con el Estado de que se trate") — see the namespace
  docstrings and `test/marketentry/governor_contract_test.clj`'s two
  contrasting fixtures for the full honest disclosure.
- `src/statute/facts.cljc` -- general-law catalog (pre-existing, not
  modified by this Wave): Código de Comercio (Decreto N.º 2-70) and
  the Ley de Acceso a la Información Pública (Decreto N.º 57-2008).

Every citation is fetch-verified against an official source this
session (rgae.gob.gt including its own PDF-hosted primary law/
regulation texts, guatecompras.gt) or extracted directly from the
primary decree PDFs via `pdftotext`. BOTH guatecompras.gt and
rgae.gob.gt were behind an active Cloudflare bot-detection challenge on
direct fetch this session (confirmed via response headers: `server:
cloudflare`, `cf-mitigated: challenge` on guatecompras.gt; a Cloudflare
challenge cookie + CSP referencing `challenges.cloudflare.com` on
rgae.gob.gt) — per this project's hard safety rule against bypassing
bot-detection challenges, every citation from these two hosts was
instead fetched through the Internet Archive Wayback Machine (recent
2025-12-31 / 2026-04-08 clean captures existed for both), the
sanctioned fallback, never a workaround of the block itself. SAT
(Superintendencia de Administración Tributaria, `sat.gob.gt` /
`portal.sat.gob.gt`) was UNREACHABLE this session both live (Cloudflare
challenge / redirect-chain-only) and via the Wayback Machine (its own
CDX index shows no substantive capture 2020-2026, only redirects or
Cloudflare `challenge-platform` artifacts) — named explicitly rather
than guessed at; RTU/Solvencia Fiscal are cited instead only at the
level AG 133-2024's own text (independently fetched this session)
states them. See `marketentry.facts`'s own docstring for the full
honest disclosure of every citation's provenance.

## Culture catalog

Alongside the market-entry / statute catalogs, this repo carries a
**country-level regional-culture catalog** (ADR-2607171400 addendum 2,
`cloud-itonami-municipality-culture-catalog` Wave 1, in
`com-junkawasaki/root`) — national dishes, protected products, beverages,
crafts, festivals and heritage sites for Guatemala:

- `src/culture/facts.cljc` — the catalog, source of truth (keyed by
  uppercase ISO3, mirroring `statute.facts`).
- `schema/culture.edn` — DataScript schema.
- `data/culture-tx.edn` — derived DataScript tx-data (regenerated from
  the catalog, never hand-edited).

City-level counterparts live in the `cloud-itonami-municipality-*` repos.
Same provenance discipline as the compliance catalogs: every entry cites a
source URL that was actually fetched and read on `:culture/retrieved-at`;
summaries state only what the cited source confirms. An item not in
`culture.facts/catalog` has no spec-basis — never fabricate one.
