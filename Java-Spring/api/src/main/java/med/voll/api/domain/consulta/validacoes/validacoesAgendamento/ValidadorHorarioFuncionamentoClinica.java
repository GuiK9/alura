package med.voll.api.domain.consulta.validacoes.validacoesAgendamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.consulta.validacoes.ValidadorAgendamento;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamento {

    public void validar(DadosAgendamentoConsulta dados){
        var daraConsulta = dados.data();
        var domingo = daraConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAberturaDaClinica = daraConsulta.getHour() < 7;
        var depoisDoEncerramentoDaClinica = daraConsulta.getHour() > 18;
        if (domingo || antesDaAberturaDaClinica || depoisDoEncerramentoDaClinica){
            throw new ValidacaoException("A consulta fora do horário de funcionamento da clinica");
        }
    }
}
