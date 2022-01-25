package br.com.alura.rh.service.reajuste;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ValidacaoPeriodoReajuste implements ValidacaoReajuste{

    public void ValidacaoReajuste(Funcionario funcionario, BigDecimal aumento){
        LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
        LocalDate dataAtual = LocalDate.now();
        long mesesEntreDatas = ChronoUnit.MONTHS.between(dataAtual, dataUltimoReajuste);
        if(mesesEntreDatas > 6){
            throw new ValidacaoException("Reajuste não pode ser realizado em até 6 meses!");
        }
    }
}
