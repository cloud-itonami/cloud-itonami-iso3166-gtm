# Business Model: Independent Public-Sector Market-Entry & Procurement Compliance Service — Guatemala

## Classification

- Repository: `cloud-itonami-iso3166-gtm`
- ISO 3166: `GTM` (Republic of Guatemala)
- Activity: public-procurement market-entry and ongoing regulatory-
  compliance navigation for an already-incorporated operator
- Social impact: [:guatemalan-sme-market-access :public-spend-transparency :cross-border-friction-reduction]

## Customer

- an already-incorporated `cloud-itonami-cofog-{code}` /
  `cloud-itonami-isco-{code}` / `cloud-itonami-unspsc-{segment}` /
  `cloud-itonami-{ISIC}` operator wanting to bid on a Guatemalan
  public contract
- a foreign SME or civic-tech vendor entering the public sector in
  Guatemala for the first time
- a `cloud-itonami-M6910` client that has just completed incorporation
  and now needs public-sector market access

## Offer

- registration walkthrough for GUATECOMPRAS
  (www.guatecompras.gt), the Sistema de Información de
  Contrataciones y Adquisiciones del Estado (Ley de Contrataciones
  del Estado, Decreto Número 57-92, Art. 4 Bis), administered by the
  Dirección General de Adquisiciones del Estado (DIGAE) under the
  Viceministerio de Transparencia Fiscal y Adquisiciones del Estado,
  Ministerio de Finanzas Públicas
- RGAE (Registro General de Adquisiciones del Estado, LCE Arts.
  71-79) dual-gate walkthrough: Título II Inscripción (base
  registration) and, when the engagement's own contract value
  requires it (Cotización/Licitación Pública tier, LCE Arts. 38/17),
  the materially heavier Título III Precalificación dossier (Acuerdo
  Gubernativo 133-2024) -- audited balance sheet, Capital de Trabajo
  Neto certification, technical/experience track record
- business/tax registration checklist: inscription in the Registro
  Mercantil GENERAL de la República de Guatemala (Código de Comercio,
  Decreto N.º 2-70 -- a SINGLE national registry, unlike Honduras's
  decentralized department-by-department chamber system), plus SAT
  Solvencia Fiscal (tax-clearance certificate)
- local-content / preferential-procurement navigation: applicable
  set-aside or preference provisions on qualifying tenders, once
  independently verified against an official source
- ongoing regulatory-change monitoring subscription
- compliance-audit export package for the client's own records

## Revenue

- per-engagement market-entry fee (one-time registration + checklist
  completion)
- recurring regulatory-change monitoring subscription
- compliance-audit export package

## Trust Controls

- any actual portal registration or filing submission requires
  Market-Entry Compliance Governor clearance and always escalates to
  human sign-off (`:filing/submit` is never automated at any phase)
- a false or fabricated regulatory-requirement claim is a HARD hold that
  cannot be overridden by human approval alone — it must be corrected
  against a cited official source first
- a claimed engagement contract value that requires RGAE Precalificación
  (Cotización/Licitación Pública tier, LCE Arts. 38/17) while only the
  lighter Inscripción (Título II) is on file is a HARD hold that cannot
  be overridden — Guatemala's own statutory value ladder (LCE Art. 43)
  means a filing at that value tier without the heavier Precalificación
  dossier is not a valid registration for that modality
- this service does **not** provide legal or tax advice; characterization
  and filing on the client's behalf beyond checklist/draft assistance
  routes to Guatemalan-licensed counsel or a registered agent
- every requirement cites the official portal or regulation, never
  invented
- Guatemala has NO enacted comprehensive data-protection law as of
  this catalog's own `statute.facts` disclosure (only competing
  legislative initiatives, none enacted) — this service does not
  fabricate a data-protection-registration requirement to fill that gap

## Boundary with adjacent actors (read before forking)

- **`com-etzhayyim-ooyake`** (etzhayyim/root): read-only civic-wayfinding
  mirror of government structure, non-commercial, barred from acting as
  or for the government (G3 impersonation ban). This blueprint is
  commercial and never claims to be an official channel.
- **`matsurigoto`** (etzhayyim/root): sovereign e-government statecraft —
  literally the government, for etzhayyim's own covenant or an adopting
  nation-state. This blueprint is an independent operator the government
  contracts with or that bids into its procurement — never the
  government.
- **`com-etzhayyim-toritsugi`** (etzhayyim/root): guides a consenting
  INDIVIDUAL citizen through their OWN procedure, non-profit,
  donation-only. This blueprint's client is a business operator, not an
  individual citizen, and it is commercial.
- **`legal-entity.etzhayyim.com`**: read-only aggregated company-registry
  data, no execution. This blueprint executes (gated) registrations.
- **`cloud-itonami-M6910`**: helps a client BECOME a legal entity
  (incorporation, ISIC 6910) — a prior, different regulatory phase
  (company law, including the initial Registro Mercantil General
  inscription). This blueprint assumes incorporation is already done
  and handles public-procurement market entry (a different regulatory
  domain), though it INDEPENDENTLY re-verifies that the client's
  claimed RGAE registration tier (Inscripción vs Precalificación)
  actually covers the value of the engagement before any filing
  submission.
- **`cloud-itonami-cofog-{code}`**: a jurisdiction-agnostic operator
  template for ONE public function. This blueprint is the orthogonal
  jurisdiction-specific axis — the two compose (fork a COFOG-function
  blueprint AND this one to operate in Guatemala).
