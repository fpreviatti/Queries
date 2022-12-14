package com.curso.atividade08;

import com.curso.atividade08.entity.Departamento;
import com.curso.atividade08.entity.Funcionario;
import com.curso.atividade08.service.DepartamentoService;
import com.curso.atividade08.service.FuncionarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Atividade08Application {

	private static final Logger log = LoggerFactory.getLogger(Atividade08Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Atividade08Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(DepartamentoService departamentoService,
								  FuncionarioService funcionarioService){

		List<Funcionario> lista = funcionarioService.findFirst3ByOrderBySalarioDesc();
		List<Funcionario> listaPorDepartamento = funcionarioService.findByDepartamento("Marketing");
		List<Funcionario> listaFuncionariosSemDependentesPorOrdemCrescente = funcionarioService.findByFuncionariosSemDependentesOrdemCrescente();
		List<Funcionario> listaFuncionariosSalarioMaiorQueValorInformado = funcionarioService.findBySalarioAfter(5000d);
		List<Funcionario> listaFuncionariosSalarioNativeQuery = funcionarioService.findBySalarioNativeQuery(6000d);
		List<Funcionario> listFuncionarioPorQuantidadeDeDependentes = funcionarioService.findByQtdDependentes(2);
		List<Funcionario> listFuncionariosPorParteDoNome = funcionarioService.findByParteDoNome("Aurelio");
		//List<Funcionario> listFuncionariosSalarioAumentado = funcionarioService.aumentarSalario(10);
		List<Funcionario> listDepartamentoSemDependentes = funcionarioService.findByDepartamentoSemDependentes("diretor");
		funcionarioService.updateDepartamentoFuncionarioByld(5,4);
		funcionarioService.excluirFuncionariosPorCodigoDepartamento(3);


		return (arg) -> {

			funcionarioService.aumentarSalario(10);

			log.info("Consulta que lista todos os funcionários de um determinado departamento que não possuam dependentes utilizando parâmetros nomeados");

			for(Funcionario funcionario : listDepartamentoSemDependentes){
				log.info(funcionario.getDepartamento().getNomeDepartamento());
				log.info(funcionario.getNomeFuncionario());

			}

			Funcionario func = new Funcionario();
			func.setNomeFuncionario("Jose Pardal");
			func.setCargo("Professor");
			func.setSalario(4000d);
			func.setQtdDependentes(2);
			func.setCodFuncionario(40);

			Departamento departamento = new Departamento();
			departamento.setNomeDepartamento("Educacao");
			departamento.setCodDepartamento(15);

			departamentoService.salvarDepartamentoEFuncionario(departamento, func);

			/*log.info("Exercicio 1 Listar um funcionário pelo seu nome e quantidade de dependentes utilizando consulta por palavras-chaves");
			log.info(funcionarioService.findByNomeFuncionarioAndQtdDependentes("Marcos Aurelio", 3).getNomeFuncionario() +
					" - Quantidade de dependentes: " + (funcionarioService.findByNomeFuncionarioAndQtdDependentes("Marcos Aurelio", 3).getQtdDependentes()));
			log.info("");

			log.info("Exercicio 2 Listar todos os funcionários de um determinado departamento por JPQL via @Query.");
			log.info("Funcionarios do Marketing");
			for(Funcionario funcionario : listaPorDepartamento){
				log.info(funcionario.getNomeFuncionario());
			}
			log.info("");

			log.info("Exercicio 3 Listar o primeiro departamento cadastrado.");
			log.info(departamentoService.findFirstBy().getNomeDepartamento());
			log.info("");

			log.info("Exercicio 4 Listar o primeiro funcionário que tem o maior salário");
			log.info(funcionarioService.findFirstByOrderBySalarioDesc().getNomeFuncionario());
			log.info("");

			log.info("Exercicio 5 Listar os 3 (três) primeiros funcionários que tem os maiores salários");
			for(Funcionario funcionario : lista){
				log.info(funcionario.getNomeFuncionario());
			}
			log.info("");

			log.info("Exercicio 6 Listar os funcionários que não tem dependentes em ordem crescente de nome por JPQL " +
					"via @Query");
			for(Funcionario funcionario : listaFuncionariosSemDependentesPorOrdemCrescente){
				log.info(funcionario.getNomeFuncionario());
			}
			log.info("");

			log.info("Exercicio 7 Listar os funcionários que tem salário maior que um determinado valor por JPQL " +
					"sobrescrevendo palavras-chaves @Query");
			log.info("Pessoas com salario maior que R$ 5000: ");
			for(Funcionario funcionario : listaFuncionariosSalarioMaiorQueValorInformado){
				log.info(funcionario.getNomeFuncionario()

				+" - Salário: " +(funcionario.getSalario().toString()));
			}
			log.info("");

			log.info("Exercicio 8 Listar os funcionários que tem salário maior que um determinado valor por @Query " +
					"com native query");
			log.info("Pessoas com salario maior que R$ 6000: ");
			for(Funcionario funcionario : listaFuncionariosSalarioNativeQuery){
				log.info(funcionario.getNomeFuncionario()

						+" - Salário: " +(funcionario.getSalario().toString()));
			}
			log.info("");

			log.info("Exercicio 9 Alterar a classe Funcionario e criar uma consulta para listar os funcionários com uma" +
					"determinada quantidade de dependentes por @NamedQuery");
			log.info("Funcionarios que possuem 2 dependentes: ");
			for(Funcionario funcionario : listFuncionarioPorQuantidadeDeDependentes){
				log.info(funcionario.getNomeFuncionario());
			}
			log.info("");

			log.info("Exercicio 10 Alterar a classe Funcionario e criar uma consulta para listar os funcionários que" +
					"contenham em qualquer parte do seu nome um determinado nome por " +
					"@NamedNativeQuery");
			for(Funcionario funcionario : listFuncionariosPorParteDoNome){
				log.info(funcionario.getNomeFuncionario());
			}*/

			/*log.info("Listagem de todos os departamentos");
			log.info("---------------------------------");
			for(Departamento departamento: departamentoService.buscarTodos())
				log.info(departamento.getNomeDepartamento().toString());
			log.info(" ");


			log.info("Listagem de todos os funcionários");
			log.info("---------------------------------");
			for(Funcionario funcionario: funcionarioService.buscarTodos())
				log.info(funcionario.getNomeFuncionario().toString());


			log.info("Listagem de todos os funcionários com salario maior que 2000");
			log.info("---------------------------------");
			log.info(funcionarioService.buscarPorNomeSalario().getNomeFuncionario() + funcionarioService.buscarPorNomeSalario().getSalario());

			log.info("Listagem do primeiro registro");
			log.info("---------------------------------");
			log.info(funcionarioService.findFirstBy().getNomeFuncionario());

			log.info("Listagem do primeiro registro usando Top");
			log.info("---------------------------------");
			log.info(funcionarioService.findTopBy().getNomeFuncionario());

			log.info("Listagem do menor salario usando Top");
			log.info("---------------------------------");
			log.info(funcionarioService.findTopOrderBySalario().getNomeFuncionario());*/

		};
	}
}
