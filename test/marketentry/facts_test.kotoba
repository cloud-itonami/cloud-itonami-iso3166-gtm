(ns marketentry.facts-test
  (:require [clojure.test :refer [deftest is testing]]
            [marketentry.facts :as facts]))

(deftest gtm-has-spec-basis
  (let [sb (facts/spec-basis "GTM")]
    (is (some? sb))
    (is (string? (:provenance sb)))
    (is (seq (:required-evidence sb)))
    (is (= 5 (count (:required-evidence sb))) "exactly 5 required-evidence items, not padded")
    (is (some? (facts/corporate-number-spec-basis "GTM")))
    (is (some? (facts/precalificacion-ceiling-spec-basis "GTM")))))

(deftest unknown-jurisdiction-has-no-spec-basis
  (is (nil? (facts/spec-basis "ATL")))
  (is (nil? (facts/spec-basis "ZZZ"))))

(deftest required-evidence-satisfied
  (let [sb (facts/spec-basis "GTM")
        all (:required-evidence sb)]
    (is (true? (facts/required-evidence-satisfied? "GTM" all)))
    (is (not (facts/required-evidence-satisfied? "GTM" (take 1 all))))
    (is (nil? (facts/required-evidence-satisfied? "ATL" all)))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["GTM" "USA" "ATL"])]
    (is (= 3 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["ATL" "USA"] (:missing-jurisdictions c)))))

(deftest no-fabricated-sat-fetch
  (testing "sat.gob.gt/portal.sat.gob.gt were Cloudflare-blocked and had no substantive Wayback capture this session -- must never be cited as an independently-browsed live or archived source"
    (let [sb (facts/spec-basis "GTM")]
      (is (re-find #"UNREACHABLE" (:corporate-number-provenance sb))
          "the gap must be disclosed in the provenance note, not concealed")
      (is (re-find #"AG 133-2024" (:corporate-number-legal-basis sb))
          "cited instead via AG 133-2024's own text, not SAT's own site"))))

(deftest required-tier-follows-the-statutory-ladder
  (testing "LCE Arts. 17/38/43 -- Baja Cuantía / Compra Directa / Cotización / Licitación Pública"
    (is (= :baja-cuantia (facts/required-tier "GTM" 10000.0)))
    (is (= :baja-cuantia (facts/required-tier "GTM" 25000.0)))
    (is (= :compra-directa (facts/required-tier "GTM" 25000.01)))
    (is (= :compra-directa (facts/required-tier "GTM" 90000.0)))
    (is (= :cotizacion (facts/required-tier "GTM" 90000.01)))
    (is (= :cotizacion (facts/required-tier "GTM" 900000.0)))
    (is (= :licitacion-publica (facts/required-tier "GTM" 900000.01)))
    (is (= :licitacion-publica (facts/required-tier "GTM" 5000000.0)))
    (is (nil? (facts/required-tier "ATL" 10000.0)) "no spec-basis for the jurisdiction at all -> no tier")))

(deftest precalificacion-required-matches-the-tiers
  (is (false? (facts/precalificacion-required? "GTM" :baja-cuantia)))
  (is (false? (facts/precalificacion-required? "GTM" :compra-directa)))
  (is (true? (facts/precalificacion-required? "GTM" :cotizacion)))
  (is (true? (facts/precalificacion-required? "GTM" :licitacion-publica)))
  (is (false? (facts/precalificacion-required? "GTM" :not-a-real-tier)))
  (is (false? (facts/precalificacion-required? "ATL" :cotizacion))))

(deftest registro-mercantil-reuses-codigo-de-comercio-citation
  (testing "the Registro Mercantil requirement cites the SAME Decreto 2-70 as statute.facts, never a second different citation"
    (let [sb (facts/spec-basis "GTM")]
      (is (some #(re-find #"Decreto N\.º 2-70" %) (:required-evidence sb)))
      (is (some #(re-find #"statute\.facts/gtm\.codigo-comercio-decreto-2-70" %) (:required-evidence sb))))))
