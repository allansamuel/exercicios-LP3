package br.ifsul;

import java.sql.Date;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Lp3Application {

	@Autowired
	private DespesaRepository dr;
	
	private static void criaDespesa(Lp3Application app) {
		String descricao = JOptionPane.showInputDialog(null, "Insira uma descrição");
		String valor = JOptionPane.showInputDialog(null, "Insira um valor");
		String data = JOptionPane.showInputDialog(null, "Insira uma data");
		
		Date d = Date.valueOf(data);
		Float f = Float.valueOf(valor);
		
		Despesa despesa = new Despesa(descricao, f, d);
		app.dr.save(despesa);
	}
	
	public static void main(String[] args) throws Throwable {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(Lp3Application.class);
		builder.headless(false);
		ApplicationContext c = builder.run(args);
		Lp3Application app = c.getBean(Lp3Application.class);
		
		String opcao = JOptionPane.showInputDialog(null, "Informe um valor para a próxima operação:\n1 - Nova despesa\n2 - Listar despesas\n3 - Sair da aplicação");
		
		while(!(opcao.equals("1") && opcao.equals("2"))) {
			opcao = JOptionPane.showInputDialog(null, "Informe um valor para a próxima operação:\n1 - Nova despesa\n2 - Listar despesas\n3 - Sair da aplicação");
			if(opcao.equals("1")) {
				criaDespesa(app);
			}else if(opcao.equals("2")) {
				for(Despesa d : app.dr.findAll()) {
					System.out.println("------DESPESA #" + d.getId() + "--------\n" + d.getDescricao() + "\n" + d.getValor() + "\n" + d.getData() + "\n");
				}
			}else {
				return;
			}
		}
		
	}
	

}
