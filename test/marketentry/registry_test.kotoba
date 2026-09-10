(ns marketentry.registry-test
  (:require [clojure.test :refer [deftest is testing]]
            [marketentry.registry :as registry]))

(deftest engagement-fee-recompute
  (let [e {:base-fee 500000 :monthly-rate 30000 :monitoring-months 12 :claimed-fee 860000.0}]
    (is (== 860000.0 (registry/compute-engagement-fee e)))
    (is (true? (registry/engagement-fee-matches-claim? e))))
  (let [bad {:base-fee 500000 :monthly-rate 30000 :monitoring-months 12 :claimed-fee 999000.0}]
    (is (false? (registry/engagement-fee-matches-claim? bad)))))

(deftest precalificacion-ceiling-mismatch-flagship
  (testing "a Cotización-tier value (> Q.90,000) with only Inscripción on file is a mismatch"
    (is (true? (registry/precalificacion-ceiling-mismatch?
                {:jurisdiction "GTM" :contract-value-gtq 500000.0 :rgae-status :inscripcion}))))
  (testing "a Cotización-tier value that IS Precalificado is NOT a mismatch"
    (is (false? (registry/precalificacion-ceiling-mismatch?
                 {:jurisdiction "GTM" :contract-value-gtq 500000.0 :rgae-status :precalificado}))))
  (testing "a Compra Directa-tier value (<= Q.90,000) with only Inscripción is NOT a mismatch -- Art. 43 does not require Precalificación there"
    (is (false? (registry/precalificacion-ceiling-mismatch?
                 {:jurisdiction "GTM" :contract-value-gtq 60000.0 :rgae-status :inscripcion}))))
  (testing "a Baja Cuantía-tier value with only Inscripción is NOT a mismatch"
    (is (false? (registry/precalificacion-ceiling-mismatch?
                 {:jurisdiction "GTM" :contract-value-gtq 10000.0 :rgae-status :inscripcion}))))
  (testing "a Licitación Pública-tier value with only Inscripción IS a mismatch"
    (is (true? (registry/precalificacion-ceiling-mismatch?
                {:jurisdiction "GTM" :contract-value-gtq 5000000.0 :rgae-status :inscripcion}))))
  (testing "no spec-basis for the jurisdiction -> no tier derivable -> never assumed a mismatch"
    (is (false? (registry/precalificacion-ceiling-mismatch?
                 {:jurisdiction "ATL" :contract-value-gtq 500000.0 :rgae-status :inscripcion})))))

(deftest register-draft-and-submit
  (let [d (registry/register-draft "eng-1" "GTM" 0)
        s (registry/register-submit "eng-1" "GTM" 0)]
    (is (= "GTM-DFT-000000" (get d "draft_number")))
    (is (= "GTM-SUB-000000" (get s "submit_number")))
    (is (nil? (get-in d ["certificate" "proof"])))
    (is (= "draft-unsigned" (get-in s ["certificate" "status"])))))

(deftest register-requires-ids
  (is (thrown? Exception (registry/register-draft "" "GTM" 0)))
  (is (thrown? Exception (registry/register-submit "eng-1" "" 0))))
