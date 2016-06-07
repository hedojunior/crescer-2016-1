create or replace package body PCK_CONCURSO is
 -- Private type declarations
 
 /* Conforme especificacao deve gerar 1 registro na tabela concurso */
 procedure geraProximoConcurso as
      -- variaveis       
   begin      
       --
       --insert into concurso ...
       null; --> remover
   end;
 ----------------------------------------------------------------------
     
 procedure atualizaAcertadores(pIDConcurso in Number)  as
      vConcursoEscolhido NUMBER;
      
      vDez1 NUMBER;
      vDez2 NUMBER;
      vDez3 NUMBER;
      vDez4 NUMBER;
      vDez5 NUMBER;
      vDez6 NUMBER;
      
      vContadorAcertos NUMBER := 0;
             
   begin      
      FOR dezena IN (SELECT * FROM Concurso con WHERE con.IDConcurso = pIDConcurso) LOOP
      vDez1 := dezena.PRIMEIRA_DEZENA;
      vDez2 := dezena.SEGUNDA_DEZENA;
      vDez3 := dezena.TERCEIRA_DEZENA;
      vDez4 := dezena.QUARTA_DEZENA;
      vDez5 := dezena.QUINTA_DEZENA;
      vDez6 := dezena.SEXTA_DEZENA;
      END LOOP;

       FOR aposta IN (SELECT * FROM Aposta ap WHERE ap.IDConcurso = pIDConcurso) LOOP
       FOR numeroDaAposta IN (SELECT * FROM NUMERO_APOSTA WHERE IDAPOSTA = aposta.IDAposta) LOOP
       IF(numeroDaAposta.Numero = vDez1
       OR numeroDaAposta.Numero = vDez2
       OR numeroDaAposta.Numero = vDez3
       OR numeroDaAposta.Numero = vDez4
       OR numeroDaAposta.Numero = vDez5
       OR numeroDaAposta.Numero = vDez6) 
       THEN
       vContadorAcertos := vContadorAcertos + 1;
       
       END IF;
       END LOOP;
       
       IF(vContadorAcertos = 3) THEN
       INSERT INTO APOSTA_PREMIADA (IDAPOSTA, ACERTOS, VALOR) 
       VALUES         (aposta.IDAposta, vContadorAcertos, aposta.Valor);      
       END IF; 
       IF(vContadorAcertos = 6) THEN
       UPDATE CONCURSO SET ACUMULOU = 0  WHERE CONCURSO.IDCONCURSO = APOSTA.IDCONCURSO;
       END IF;
       
       END LOOP;

         NULL;
   END;

   
begin
 -- Initialization
 null;
end PCK_CONCURSO;