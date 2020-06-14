INSERT INTO tip (koda) VALUES ('TEMP1');
INSERT INTO tip (koda) VALUES ('TEMP2');
INSERT INTO tip (koda) VALUES ('VLA1');
INSERT INTO tip (koda) VALUES ('VLA2');
INSERT INTO tip (koda) VALUES ('TEZA');

INSERT INTO podnica (naziv) VALUES ('Dominikova podnica');
INSERT INTO podnica (naziv) VALUES ('Gašperjeva podnica');

INSERT INTO meritev (vrednost, tip_koda, cas_meritve, podnica) VALUES (25.8, 'TEMP1', '2015-08-07 05:00:01', 1);
INSERT INTO meritev (vrednost, tip_koda, cas_meritve, podnica) VALUES (23.8, 'TEMP1', '2015-08-06 05:00:01', 1);
INSERT INTO meritev (vrednost, tip_koda, cas_meritve, podnica) VALUES (24.8, 'TEMP2', '2015-08-08 06:00:01', 1);
INSERT INTO meritev (vrednost, tip_koda, cas_meritve, podnica) VALUES (21.8, 'TEMP2', '2015-08-07 06:00:01', 1);
INSERT INTO meritev (vrednost, tip_koda, cas_meritve, podnica) VALUES (21.8, 'TEMP2', '2020-05-07 15:00:01', 1);
INSERT INTO meritev (vrednost, tip_koda, cas_meritve, podnica) VALUES (21.8, 'TEMP2', '2020-05-07T11:00:01Z', 1);
INSERT INTO meritev (vrednost, tip_koda, cas_meritve, podnica) VALUES (80, 'VLA1', '2015-08-09 07:00:01', 1);
INSERT INTO meritev (vrednost, tip_koda, cas_meritve, podnica) VALUES (85, 'VLA1', '2015-08-10 07:00:01', 1);
INSERT INTO meritev (vrednost, tip_koda, cas_meritve, podnica) VALUES (70, 'VLA2', '2015-08-07 08:00:01', 1);
INSERT INTO meritev (vrednost, tip_koda, cas_meritve, podnica) VALUES (75, 'VLA2', '2015-08-03 08:00:01', 1);
INSERT INTO meritev (vrednost, tip_koda, cas_meritve, podnica) VALUES (40, 'TEZA', '2015-08-03 08:00:01', 1);
INSERT INTO meritev (vrednost, tip_koda, cas_meritve, podnica) VALUES (41, 'TEZA', '2015-08-04 08:00:01', 1);
INSERT INTO meritev (vrednost, tip_koda, cas_meritve, podnica) VALUES (5, 'TEZA', '2017-08-04 08:00:01', 2);

-- INSERT INTO varoa(cas_meritve, podnica, ime_datoteke) VALUES ('2020-05-07 15:00:01', 1, '1lcgv7BngabNUVNS7GzfIFr2ETVGuBhcRRTNark9BFI8VaAAZl.jpg');
-- INSERT INTO varoa(cas_meritve, podnica, ime_datoteke) VALUES ('2020-05-07 17:00:01', 1, '2lOgS1V8NDjroaRJB2MZkf7NrVkTDhDJcf4FZFjfShz5Ea6fHRE.jpg');
-- INSERT INTO varoa(cas_meritve, podnica, ime_datoteke) VALUES ('2020-05-07 13:00:01', 2, '84p7MdiaCdM65PNU5k1A88iFt9eBuncKT46fFVbsngCLN02GtM.jpg');
-- INSERT INTO varoa(cas_meritve, podnica, ime_datoteke) VALUES ('2020-05-07 11:59:01', 1, 'hSc6IkPjt5fMMrL4m11PnnhlgH8pKiHvf2VDaBOIKN2j4sjUpo.jpg');
-- INSERT INTO varoa(cas_meritve, podnica, ime_datoteke) VALUES ('2020-04-07 15:00:01', 1, 'J3maurfUE8ODpG1EB7NhZnd3iCUe4ul7c123ocC0IlTFru2F4A.jpg');
-- INSERT INTO varoa(cas_meritve, podnica, ime_datoteke) VALUES ('2020-06-07 15:00:01', 1, 'pD0nZKO01FJ3vCKCOIU5mDvpjKOuO08g5RBcGdv204SC8H1rGT.jpg');
