INSERT INTO tip (koda) VALUES ('TEMP1');
INSERT INTO tip (koda) VALUES ('TEMP2');
INSERT INTO tip (koda) VALUES ('VLA1');
INSERT INTO tip (koda) VALUES ('VLA2');
INSERT INTO tip (koda) VALUES ('VAROA');
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
