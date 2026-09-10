(ns culture.facts
  "Country-level regional-culture catalog for Guatemala (GTM) -- national
  dishes, protected products, beverages, crafts, festivals and heritage
  sites, per ADR-2607171400 addendum 2 (cloud-itonami-municipality-
  culture-catalog Wave 1, in com-junkawasaki/root). Sibling namespace to
  `marketentry.facts` / `statute.facts` (ADR-2607141700); city-level
  counterparts live in the cloud-itonami-municipality-* repos.

  Catalog is keyed by UPPERCASE ISO3 (mirrors `statute.facts`); entries
  carry no :culture/municipality (that attribute is city-level only).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of culture entries."
  {"GTM"
   [{:culture/id "gtm.dish.pepian"
     :culture/name "Pepián"
     :culture/country "GTM"
     :culture/kind :dish
     :culture/summary "Thick meat stew from Guatemala, among the country's most iconic dishes, blending Spanish colonial and indigenous influences with ingredients such as gourd seeds, tomatillo, tomato and chili peppers."
     :culture/url "https://en.wikipedia.org/wiki/Pepi%C3%A1n"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "gtm.dish.kakik"
     :culture/name "Kak'ik"
     :culture/country "GTM"
     :culture/kind :dish
     :culture/summary "Soup made from a type of turkey called chompipe, typical of Guatemalan cuisine with pre-Hispanic Maya origins; Guatemala recognised it as intangible cultural heritage in 2007."
     :culture/url "https://en.wikipedia.org/wiki/Kak%27ik"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "gtm.dish.fiambre"
     :culture/name "Fiambre"
     :culture/country "GTM"
     :culture/kind :dish
     :culture/summary "Traditional Guatemalan salad with dozens of ingredients, served chilled, prepared and eaten yearly to celebrate the Day of the Dead and All Saints' Day."
     :culture/url "https://en.wikipedia.org/wiki/Fiambre"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "gtm.product.coffee"
     :culture/name "Guatemalan coffee"
     :culture/country "GTM"
     :culture/kind :product
     :culture/summary "Coffee is an important element of Guatemala's economy; Guatemala became Central America's leading coffee producer by the late 19th century and was overtaken by Honduras in 2011."
     :culture/url "https://en.wikipedia.org/wiki/Coffee_production_in_Guatemala"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "gtm.craft.maya-textiles"
     :culture/name "Maya textiles"
     :culture/country "GTM"
     :culture/kind :craft
     :culture/summary "Brightly coloured yarn-based textiles woven by the Maya people of Guatemala into capes, shirts, blouses and dresses; each village has its own distinctive pattern."
     :culture/url "https://en.wikipedia.org/wiki/Culture_of_Guatemala"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "gtm.festival.holy-week-processions"
     :culture/name "Holy Week processions in Guatemala"
     :culture/country "GTM"
     :culture/kind :festival
     :culture/summary "Street expressions of faith during Guatemala's Semana Santa, usually organised by a hermandad, featuring religious floats and sculptures."
     :culture/url "https://en.wikipedia.org/wiki/Holy_Week_processions_in_Guatemala"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "gtm.heritage.tikal"
     :culture/name "Tikal"
     :culture/country "GTM"
     :culture/kind :heritage
     :culture/summary "Ruin of an ancient Maya city in Guatemala's Petén Department, one of the largest archaeological sites of the pre-Columbian Maya civilisation, a UNESCO World Heritage Site since 1979."
     :culture/url "https://en.wikipedia.org/wiki/Tikal"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "gtm.heritage.antigua-guatemala"
     :culture/name "Antigua Guatemala"
     :culture/country "GTM"
     :culture/kind :heritage
     :culture/summary "Historic city in Guatemala's central highlands, capital of the Captaincy General of Guatemala from 1543 through 1773, designated a UNESCO World Heritage Site in 1979."
     :culture/url "https://en.wikipedia.org/wiki/Antigua_Guatemala"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

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
      :note (str "cloud-itonami-iso3166-gtm culture catalog "
                 "(ADR-2607171400 addendum 2, Wave 1): " (count (get catalog "GTM"))
                 " GTM entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [iso3 kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis iso3)))
