package interfac;

/**Tela de que ir� mostrar os dados cadastrados no jlist, dar refresh e estabelecer o pesquisador
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

import control.ControleDados;
import control.ControleEspectador;
import control.ControleFilme;
import control.ControleIngresso;

public class TelaFilme implements ActionListener, ListSelectionListener {
	private JFrame janela;
	private JLabel titulo;
	private JButton cadastroFilme;
	private JButton refreshFilme;
	private JButton cadastroEspectador;
	private JButton refreshEspectador;
	private JButton cadastroIngresso;
	private JButton refreshIngresso;

	private JButton pesquisaIngresso;
	private JTextField buscaIngr;

	private JButton pesquisaFilme;
	private JTextField buscaFilme;

	private JButton pesquisaEspectador;
	private JTextField buscaEsp;

	private JLabel descricao;

	private JButton acompanhamento;

	private static ControleDados dados;
	private JList<String> listaMovie;
	private JList<String> listaEspectador;
	private JList<String> listaIngresso;
	private String[] listaNomes = new String[100];

	/**
	 * Cria a tela pra mostrar os dados no jlist com bot�es e o pesquisador
	 * 
	 * @author Pedro V.
	 * @param d   ControleDado - Manipular os dados do array
	 * @param esc int - Indica qual tela ser� mostrada de Filme, espectador ou
	 *            ingresso
	 */

	public void mostrarDados(ControleDados d, int esc) {
		dados = d;

		// Mostrar dados de filmes cadastrados (JList)

		switch (esc) {

		case 1:
			listaNomes = new ControleFilme(dados).getNomeFilme();
			listaMovie = new JList<String>(listaNomes);

			janela = new JFrame("Filmes");
			titulo = new JLabel("Filmes Cadastrados");

			cadastroFilme = new JButton("Cadastrar");
			refreshFilme = new JButton("Refresh");
			pesquisaFilme = new JButton("Pesquisar");

			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(100, 10, 250, 30);

			listaMovie.setBounds(20, 50, 350, 120);
			listaMovie.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaMovie.setVisibleRowCount(10);

			cadastroFilme.setBounds(80, 250, 100, 30);
			refreshFilme.setBounds(210, 250, 100, 30);
			pesquisaFilme.setBounds(250, 200, 100, 30);
			buscaFilme = new JTextField(200);
			buscaFilme.setBounds(30, 200, 190, 30);
			descricao = new JLabel("Pesquise pelo nome do filme");
			descricao.setBounds(30, 175, 190, 30);

			janela.setLayout(null);
			janela.setResizable(false);
			janela.setLocationRelativeTo(null);

			janela.add(titulo);
			janela.add(listaMovie);
			janela.add(cadastroFilme);
			janela.add(refreshFilme);
			janela.add(pesquisaFilme);
			janela.add(buscaFilme);
			janela.add(descricao);

			janela.setSize(400, 350);
			janela.setVisible(true);

			pesquisaFilme.addActionListener(this);
			cadastroFilme.addActionListener(this);
			refreshFilme.addActionListener(this);
			listaMovie.addListSelectionListener(this);
			buscaFilme.getText();

			break;

		case 2:

			listaNomes = new ControleEspectador(dados).getNome();
			listaEspectador = new JList<String>(listaNomes);

			janela = new JFrame("Espectadores Cadastrados");
			titulo = new JLabel("Espectadores ");
			cadastroEspectador = new JButton("Cadastrar");
			refreshEspectador = new JButton("Refresh");
			pesquisaEspectador = new JButton("Pesquisar");

			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(125, 10, 250, 30);

			listaEspectador.setBounds(20, 50, 350, 120);
			listaEspectador.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaEspectador.setVisibleRowCount(10);

			cadastroEspectador.setBounds(80, 250, 100, 30);
			refreshEspectador.setBounds(210, 250, 100, 30);
			pesquisaEspectador.setBounds(250, 200, 100, 30);

			buscaEsp = new JTextField(200);
			buscaEsp.setBounds(30, 200, 210, 30);
			descricao = new JLabel("Pesquise pelo nome do Espectador");
			descricao.setBounds(30, 175, 250, 30);

			janela.setLayout(null);
			janela.setResizable(false);
			janela.setLocationRelativeTo(null);

			janela.add(titulo);
			janela.add(listaEspectador);
			janela.add(cadastroEspectador);
			janela.add(refreshEspectador);
			janela.add(descricao);
			janela.add(buscaEsp);
			janela.add(pesquisaEspectador);

			janela.setSize(400, 350);
			janela.setVisible(true);

			pesquisaEspectador.addActionListener(this);
			cadastroEspectador.addActionListener(this);
			refreshEspectador.addActionListener(this);
			listaEspectador.addListSelectionListener(this);
			break;

		case 3:

			listaNomes = new ControleIngresso(dados).getNomeIngresso();

			listaIngresso = new JList<String>(listaNomes);

			janela = new JFrame("Ingressos Cadastrados");
			titulo = new JLabel("Ingressos");

			pesquisaIngresso = new JButton("Pesquisar");
			cadastroIngresso = new JButton("Novo");
			refreshIngresso = new JButton("Refresh");
			acompanhamento = new JButton("Acompanhamento");

			buscaIngr = new JTextField(200);
			buscaIngr.setBounds(20, 200, 220, 30);
			descricao = new JLabel("Pesquise pelo HORA ou SALA do filme");
			descricao.setBounds(20, 165, 300, 40);

			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(145, 10, 250, 30);

			listaIngresso.setBounds(20, 50, 350, 120);
			listaIngresso.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaIngresso.setVisibleRowCount(10);

			cadastroIngresso.setBounds(20, 250, 90, 30);
			refreshIngresso.setBounds(270, 250, 90, 30);
			acompanhamento.setBounds(120, 250, 140, 30);
			pesquisaIngresso.setBounds(255, 200, 100, 30);

			janela.setLayout(null);
			janela.setResizable(false);
			janela.setLocationRelativeTo(null);

			janela.add(titulo);
			janela.add(listaIngresso);
			janela.add(cadastroIngresso);
			janela.add(refreshIngresso);
			janela.add(acompanhamento);
			janela.add(pesquisaIngresso);
			janela.add(buscaIngr);
			janela.add(descricao);

			janela.setSize(400, 350);
			janela.setVisible(true);

			acompanhamento.addActionListener(this);
			cadastroIngresso.addActionListener(this);
			refreshIngresso.addActionListener(this);
			listaIngresso.addListSelectionListener(this);
			pesquisaIngresso.addActionListener(this);

		}
	}

	@Override
	// Captura de enventos
	/**
	 * M�todo que executa uma a��p de acordo com o evento escutado em um elemento do
	 * jlist selecionado
	 * 
	 * @author Pedro V.
	 * @param acao ActionSelectionEvent - A��o escutada pelo ListSelectionListener
	 */
	public void valueChanged(ListSelectionEvent acao) {
		Object src = acao.getSource();

		// Consequ�ncia gatilhos
		if (acao.getValueIsAdjusting() && src == listaMovie) {
			new TelaEdit().inserirEditar(4, dados, this, listaMovie.getSelectedIndex());
		}
		if (acao.getValueIsAdjusting() && src == listaEspectador) {
			new TelaEdit().inserirEditar(5, dados, this, listaEspectador.getSelectedIndex());
		}
		if (acao.getValueIsAdjusting() && src == listaIngresso) {
			new TelaEdit().inserirEditar(6, dados, this, listaIngresso.getSelectedIndex());
		}


	}

	@Override

	// Gatilho bot�es
	/**
	 * M�todo que executa uma a��o de acordo com o evento escutado. Por aqui ser�
	 * realizado o cadastro, edi��o ou remo��o dos dados
	 * 
	 * @author Pablo C e Pedro V.
	 * @param acao ActionEvent - A��o escutada pelo ActionListener
	 */
	public void actionPerformed(ActionEvent acao) {
		Object gatilho = acao.getSource();

		// Gatilhos para a pagina filme -> Exibi��o, Cadastro, Edit e Busca

		if (gatilho == cadastroFilme) {
			new TelaEdit().inserirEditar(1, dados, this, 0);
		}

		if (gatilho == refreshFilme) {

			listaMovie.setListData(new ControleFilme(dados).getNomeFilme());
			listaMovie.updateUI();

		}

		if (gatilho == pesquisaFilme) {

			listaMovie.setListData(new ControleFilme(dados).getPesquisaFilme(buscaFilme.getText()));
			listaMovie.updateUI();

		}

		// Gatilhos para a pagina espectador -> Exibi��o, Cadastro e Edit

		if (gatilho == cadastroEspectador) {
			new TelaEdit().inserirEditar(2, dados, this, 0);

		}
		if (gatilho == refreshEspectador) {
			listaEspectador.setListData(new ControleEspectador(dados).getNome());
			listaEspectador.updateUI();
		}

		if (gatilho == pesquisaEspectador) {
			listaEspectador.setListData(new ControleEspectador(dados).getPesquisaEspectador(buscaEsp.getText()));
			listaEspectador.updateUI();

		}

		// Gatilhos para a pagina ingresso -> Exibi��o, Cadastro e Edit

		if (gatilho == cadastroIngresso) {
			new TelaEdit().inserirEditar(3, dados, this, 0);

		}
		if (gatilho == refreshIngresso) {
			listaIngresso.setListData(new ControleIngresso(dados).getNomeIngresso());
			listaIngresso.updateUI();
		}
		if (gatilho == pesquisaIngresso) {
			listaIngresso.setListData(new ControleIngresso(dados).getPesquisaEsp(buscaIngr.getText()));
			listaIngresso.updateUI();

		}
		if (gatilho == acompanhamento) {
			new TelaAcompanhamento().mostrarDados(dados);
			;
		}


	}

}
