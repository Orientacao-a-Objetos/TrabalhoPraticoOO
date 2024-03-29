package interfac;

/**Tela de que ir� mostrar os dados cadastrados no jlist, dar refresh e estabelecer pesquisador dos acompanhamentos
 * @version 1.0
 * @author Pedro V.
 * @since Out 2021
 */

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import control.ControleAcompanhamento;
import control.ControleDados;

/**
 * @author pablo
 *
 */
public class TelaAcompanhamento implements ActionListener, ListSelectionListener {

	private JFrame janela;

	private JButton cadastroAcompanhamento;
	private JButton refreshAcompanhamento;

	private JButton pesquisaAcompanhamento;
	private JTextField buscaAcom;

	private JLabel descricao;

	private static ControleDados dados;

	private JList<String> listaAcompanhamentos;
	private String[] listaNomes = new String[100];

	/**
	 * Cria a tela pra mostrar os dados de acompanhamento no jlist com bot�es e o
	 * pesquisador
	 * 
	 * @author Pedro V.
	 * @param d ControleDado - Manipular os dados do array
	 * @return mostrar os dados setada
	 */
	public void mostrarDados(ControleDados d) {
		dados = d;

		listaNomes = new ControleAcompanhamento(dados).getNome();
		listaAcompanhamentos = new JList<String>(listaNomes);

		janela = new JFrame("Acompanhamentos Cadastrados");
		JLabel titulo = new JLabel("Acompanhamentos ");

		cadastroAcompanhamento = new JButton("Cadastrar");
		refreshAcompanhamento = new JButton("Refresh");
		pesquisaAcompanhamento = new JButton("Pesquisar");

		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(100, 10, 250, 30);

		listaAcompanhamentos.setBounds(20, 50, 350, 120);
		listaAcompanhamentos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaAcompanhamentos.setVisibleRowCount(10);

		pesquisaAcompanhamento.setBounds(275, 200, 100, 30);
		cadastroAcompanhamento.setBounds(70, 250, 100, 30);
		refreshAcompanhamento.setBounds(200, 250, 100, 30);

		buscaAcom = new JTextField(200);
		buscaAcom.setBounds(20, 200, 240, 30);
		descricao = new JLabel("Pesquise pelo nome do acompanhamento");
		descricao.setBounds(20, 170, 250, 30);

		janela.setLayout(null);
		janela.setResizable(false);
		janela.setLocationRelativeTo(null);

		janela.add(titulo);
		janela.add(listaAcompanhamentos);
		janela.add(cadastroAcompanhamento);
		janela.add(refreshAcompanhamento);
		janela.add(descricao);
		janela.add(pesquisaAcompanhamento);
		janela.add(buscaAcom);

		janela.setSize(400, 340);
		janela.setVisible(true);
		janela.setLayout(null);
		janela.setResizable(false);
		janela.setLocationRelativeTo(null);

		cadastroAcompanhamento.addActionListener(this);
		refreshAcompanhamento.addActionListener(this);
		listaAcompanhamentos.addListSelectionListener(this);
		pesquisaAcompanhamento.addActionListener(this);

	}

	// Captura de enventos
	@Override
	/**
	 * M�todo que executa uma a��p de acordo com o evento escutado em um elemento do
	 * jlist selecionado
	 * 
	 * @author Pedro V.
	 * @param acao ActionSelectionEvent - A��o escutada pelo ListSelectionListener
	 */
	public void valueChanged(ListSelectionEvent acao) {
		Object src = acao.getSource();

		// Consequ�ncia gatilho lista
		if (acao.getValueIsAdjusting() && src == listaAcompanhamentos) {
			new TelaEditCad().inserirEditar(2, dados, this, listaAcompanhamentos.getSelectedIndex());
		}


	}

	// Gatilho bot�es

	@Override
	/**
	 * M�todo que executa uma a��o de acordo com o evento escutado. Por aqui ser�
	 * feita a a��o de cadastro e atualiza��o do jlist pelo refresh
	 * 
	 * @author Pedro V.
	 * @param acao ActionEvent - A��o escutada pelo ActionListener
	 */
	public void actionPerformed(ActionEvent acao) {
		Object gatilho = acao.getSource();

		if (gatilho == cadastroAcompanhamento) {
			new TelaEditCad().inserirEditar(1, dados, this, 0);

		}
		if (gatilho == refreshAcompanhamento) {

			listaAcompanhamentos.setListData(new ControleAcompanhamento(dados).getNome());
			listaAcompanhamentos.updateUI();

		}

		if (gatilho == pesquisaAcompanhamento) {
			listaAcompanhamentos
					.setListData(new ControleAcompanhamento(dados).getPesquisaAcompanhamento(buscaAcom.getText()));
			listaAcompanhamentos.updateUI();

		}
	}
}
