package br.ifsul;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lp3Application extends UIDespesa {

	@Autowired
	private DespesaRepository dr;

	public static void main(String[] args) throws Throwable {
		SpringApplication.run(Lp3Application.class, args);

	}

	@Override
	protected void onNovaDespesa() {
		String des = txtDescricaoDespesa.getText();
		String val = txtValorDespesa.getText();
		String dat = txtDataDespesa.getText();

		Despesa d = new Despesa();
		d.setDescricao(des);
		d.setData(Date.valueOf(dat));
		d.setValor(Float.parseFloat(val));

		d = dr.save(d);

		modelDespesas.addElement(d);
	}

	@Override
	protected void onRemoverDespesa(Despesa selecionado) {
		dr.delete(selecionado);
		modelDespesas.removeElement(selecionado);

	}
	
	

}
