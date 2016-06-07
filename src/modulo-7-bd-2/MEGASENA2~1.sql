
SELECT * FROM 
( SELECT  
    ci.UF ESTADO,
      COUNT(1) QTD_APOSTAS, 
        SUM(ap.VALOR) VALOR_TOTAL 
          FROM Cidade ci 
            JOIN Aposta ap 
              ON ci.IDCIDADE = ap.IDCIDADE 
                WHERE ap.IDCONCURSO = 1824 
                  GROUP BY  ci.UF 
                    ORDER BY COUNT(1) DESC) 
WHERE ROWNUM <= 5;
