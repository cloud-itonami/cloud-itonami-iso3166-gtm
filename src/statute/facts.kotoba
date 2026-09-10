(ns statute.facts
  "General-law compliance catalog for Guatemala (GTM). Like
  cloud-itonami-iso3166-ury/-cri/-pan/-ecu/-pry, this repo had no
  `marketentry.facts` implementation yet (blueprint-only) -- this is
  the FIRST code-bearing content in this repo, self-contained with its
  own deps.edn. Mirrors
  cloud-itonami-iso3166-jpn/-usa/-esp/-swe/-nor/-dnk/-fin/-prt/-bel/-bra/-mex/-chl/-arg/-zaf/-col/-ury/-cri/-pan/-ecu/-pry's
  `statute.facts` (ADR-2607141700, cloud-itonami-compliance-fact-federation).

  congreso.gob.gt (the primary official Guatemalan legislative portal)
  returned HTTP 403. Both entries here instead cite official
  international-organization law mirrors that DID render fully:
  WIPO Lex (a World Intellectual Property Organization law database)
  for the Commercial Code, and CEPAL/ECLAC's Observatorio del
  Principio 10 (a United Nations regional intergovernmental body's
  environmental/access-to-information law database) for the
  Access to Public Information Law.

  Guatemala genuinely has NO comprehensive data protection law as of
  this tick -- confirmed via WebSearch that as of 2025 only three
  competing legislative INITIATIVES exist (none enacted). No
  data-protection entry is included here; fabricating one would
  violate this project's no-fabrication discipline.

  A law not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of statute entries."
  {"GTM"
   [{:statute/id "gtm.codigo-comercio-decreto-2-70"
     :statute/title "Código de Comercio (Decreto N.º 2-70)"
     :statute/jurisdiction "GTM"
     :statute/kind :law
     :statute/law-number "Decreto N.º 2-70"
     :statute/url "https://www.wipo.int/edocs/lexdocs/laws/es/gt/gt010es.pdf"
     :statute/url-provenance :official-wipo-lex-mirror
     :statute/enacted-date "1970-01-28"
     :statute/retrieved-at "2026-07-16"
     :statute/topic #{:corporate-governance :incorporation}}
    {:statute/id "gtm.ley-acceso-informacion-publica-decreto-57-2008"
     :statute/title "Ley de Acceso a la Información Pública (Decreto N.º 57-2008)"
     :statute/jurisdiction "GTM"
     :statute/kind :law
     :statute/law-number "Decreto N.º 57-2008"
     :statute/url "https://observatoriop10.cepal.org/es/instrumento/ley-acceso-la-informacion-publica-decreto-no-57-2008"
     :statute/url-provenance :official-cepal-observatorio
     :statute/enacted-date "2008-10-23"
     :statute/retrieved-at "2026-07-16"
     :statute/topic #{:information-disclosure :transparency}}]})

(defn spec-basis [iso3] (get catalog iso3))

(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-gtm statute.facts Wave 0 (ADR-2607141700): "
                 (count (get catalog "GTM")) " GTM statutes seeded with "
                 "official WIPO Lex/CEPAL citations. Extend "
                 "`statute.facts/catalog`, never fabricate a law-id or URL.")})))

(defn by-topic [iso3 topic]
  (filterv #(contains? (:statute/topic %) topic) (spec-basis iso3)))
