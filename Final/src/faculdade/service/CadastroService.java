package faculdade.service;

import faculdade.model.*;
import faculdade.repository.*;

public class CadastroService {

    public String cadastrarAluno(String nome, String matricula, String cursoNome, String login, String senha) {
        if (AlunoRepository.buscarPorMatricula(matricula) != null) {
            return "Falha: Matrícula " + matricula + " já existe.";
        }

        Aluno novoAluno = new Aluno(nome, matricula, cursoNome, login, senha);
        AlunoRepository.salvar(novoAluno);
        return "Sucesso: Aluno(a) " + nome + " cadastrado.";
    }

    public String cadastrarProfessor(String nome, String especialidade, String registro, String login, String senha) {
        if (ProfessorRepository.buscarPorRegistro(registro) != null) {
            return "Falha: Registro de professor " + registro + " já existe.";
        }

        Professor novoProfessor = new Professor(nome, especialidade, registro, login, senha);
        ProfessorRepository.salvar(novoProfessor);
        return "Sucesso: Professor(a) " + nome + " cadastrado.";
    }

    public String cadastrarCurso(String nome, String codigo, int cargaHoraria, String tipo, String detalhe) {
        if (CursoRepository.buscarPorCodigo(codigo) != null) {
            return "Falha: Código de curso " + codigo + " já existe.";
        }

        Curso novoCurso = null;
        if (tipo.equalsIgnoreCase("P")) {
            novoCurso = new CursoPresencial(nome, codigo, cargaHoraria, detalhe);
        } else if (tipo.equalsIgnoreCase("E")) {
            novoCurso = new CursoEAD(nome, codigo, cargaHoraria, detalhe);
        } else {
            return "Falha: Tipo de curso inválido (P - Presencial / E - EAD).";
        }

        CursoRepository.salvar(novoCurso);
        return "Sucesso: Curso " + nome + " (" + tipo + ") cadastrado.";
    }

    public String criarTurma(String codigoTurma, String registroProfessor, String codigoCurso) {
        Professor professor = ProfessorRepository.buscarPorRegistro(registroProfessor);
        Curso curso = CursoRepository.buscarPorCodigo(codigoCurso);

        if (professor == null) return "Falha: Professor com registro " + registroProfessor + " não encontrado.";
        if (curso == null) return "Falha: Curso com código " + codigoCurso + " não encontrado.";
        if (TurmaRepository.buscarPorCodigo(codigoTurma) != null) return "Falha: Turma " + codigoTurma + " já existe.";

        Turma novaTurma = new Turma(codigoTurma, professor, curso);
        TurmaRepository.salvar(novaTurma);
        return "Sucesso: Turma " + codigoTurma + " criada com Professor " + professor.getNome() + ".";
    }

    public String associarAlunoTurma(String matriculaAluno, String codigoTurma) {
        Aluno aluno = AlunoRepository.buscarPorMatricula(matriculaAluno);
        Turma turma = TurmaRepository.buscarPorCodigo(codigoTurma);

        if (aluno == null) return "Falha: Aluno com matrícula " + matriculaAluno + " não encontrado.";
        if (turma == null) return "Falha: Turma " + codigoTurma + " não encontrada.";

        turma.adicionarAluno(aluno);
        TurmaRepository.salvar(turma); // Atualiza a lista (simulação C.R.U.D.)
        return "Sucesso: Aluno " + aluno.getNome() + " associado à turma " + codigoTurma + ".";
    }
}