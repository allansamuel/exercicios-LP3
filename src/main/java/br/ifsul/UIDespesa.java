package br.ifsul;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public abstract class UIDespesa extends JFrame implements ActionListener {

	protected JLabel lblDespesa = new JLabel("Nova despesa");
	protected JLabel lblListaDespesa = new JLabel("Despesas cadastradas");
	protected JList<Despesa> listDespesas = new JList<Despesa>();
	protected DefaultListModel<Despesa> modelDespesas = new DefaultListModel<>();
	protected JButton btCadastrarDespesa = new JButton("Savar despesa");
	protected JButton btRemoverDespesa = new JButton("Remover despesa");
	protected JTextField txtDescricaoDespesa = new JTextField();
	protected JTextField txtDataDespesa = new JTextField();
	protected JTextField txtValorDespesa = new JTextField();

	public UIDespesa() {
		super("LP3 - Utilizando Spring Data");

		this.setLayout(new GridLayout(0, 1));

		this.txtDescricaoDespesa.setBorder(new TitledBorder("Descrição"));
		this.txtValorDespesa.setBorder(new TitledBorder("Valor"));
		this.txtDataDespesa.setBorder(new TitledBorder("Data"));

		this.listDespesas.setModel(modelDespesas);
		
		this.btCadastrarDespesa.addActionListener(this);
		this.btRemoverDespesa.addActionListener(this);

		// teste (esses dados devem vir do banco de dados, 
		// mas não aqui no método construtor)
//		modelDespesas.addElement(new Despesa("Chocolate"));
//		modelDespesas.addElement(new Despesa("Café"));
//		modelDespesas.addElement(new Despesa("Suco"));
//		modelDespesas.addElement(new Despesa("Almoço"));
//		modelDespesas.addElement(new Despesa("Gasolina"));
//		modelDespesas.addElement(new Despesa("Netflix"));

		this.getContentPane().add(lblDespesa);
		this.getContentPane().add(txtDescricaoDespesa);
		this.getContentPane().add(txtValorDespesa);
		this.getContentPane().add(txtDataDespesa);
		this.getContentPane().add(btCadastrarDespesa);
		this.getContentPane().add(lblListaDespesa);
		this.getContentPane().add(new JScrollPane(listDespesas));
		this.getContentPane().add(btRemoverDespesa);

		this.setSize(400, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btCadastrarDespesa) {
			onNovaDespesa();
		} else if (e.getSource() == btRemoverDespesa) {
			Despesa d = listDespesas.getSelectedValue();
			onRemoverDespesa(d);
		}
	}

	protected abstract void onNovaDespesa();

	protected abstract void onRemoverDespesa(Despesa selecionado);
}
