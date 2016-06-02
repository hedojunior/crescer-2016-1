CREATE OR REPLACE
FUNCTION
CHECAR_GANHADOR(vN1 IN NUMBER, vN2 IN NUMBER, vN3 IN NUMBER, vN4 IN NUMBER, vN5 IN NUMBER, VN6 IN NUMBER)
RETURN vTotalGanhadores as
BEGIN
    for reg in (SELECT * FROM ARQUIVO_APOSTA_A) LOOP
      if (
      (reg(n1) or reg(n2) or reg(n3) or reg(n4) or reg(n5) or reg(n6) or reg(n7) or reg(n8) or reg(n9) or reg(n10) or reg(n11) or reg(n12) or reg(n13) or reg(n14) or reg(n15) = vN1)
      and
      (reg(n1) or reg(n2) or reg(n3) or reg(n4) or reg(n5) or reg(n6) or reg(n7) or reg(n8) or reg(n9) or reg(n10) or reg(n11) or reg(n12) or reg(n13) or reg(n14) or reg(n15) = vN2)
      and
      (reg(n1) or reg(n2) or reg(n3) or reg(n4) or reg(n5) or reg(n6) or reg(n7) or reg(n8) or reg(n9) or reg(n10) or reg(n11) or reg(n12) or reg(n13) or reg(n14) or reg(n15) = vN3)
      and
      (reg(n1) or reg(n2) or reg(n3) or reg(n4) or reg(n5) or reg(n6) or reg(n7) or reg(n8) or reg(n9) or reg(n10) or reg(n11) or reg(n12) or reg(n13) or reg(n14) or reg(n15) = vN4)
      and 
      (reg(n1) or reg(n2) or reg(n3) or reg(n4) or reg(n5) or reg(n6) or reg(n7) or reg(n8) or reg(n9) or reg(n10) or reg(n11) or reg(n12) or reg(n13) or reg(n14) or reg(n15) = vN5)
      and
      (reg(n1) or reg(n2) or reg(n3) or reg(n4) or reg(n5) or reg(n6) or reg(n7) or reg(n8) or reg(n9) or reg(n10) or reg(n11) or reg(n12) or reg(n13) or reg(n14) or reg(n15) = vN6)
      )
      THEN
        FETCH reg(APOSTA) IN vTotalGanhadores;
    END LOOP;
  END;