package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

//Para controlar a ação do meu formulario eu preciso de uma classe que implemente ActionListener
//Boa pratica é a classe que cria os botões ficam responsaveis pelas ações desse botão
public class CadastroPessoa  extends JFrame implements ActionListener{
	    //JOptionPane.showMessageDialog( null, "Pessoa Ja cadastrada");

	    private JTextField nome;
	    private JTextField fone;
	    private JTextField email;
	    private JTextField cpf;
	    private JTextField ddd;
	    private JTextField id;

	    public CadastroPessoa() {

	        this.setBounds(300, 300, 600, 298);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.getContentPane().setLayout(null);

	        JLabel label;
	        JLabel label_1;
	        JLabel lblNome = new JLabel("Nome:");
	        lblNome.setBounds(30, 48, 70, 15);
	        this.getContentPane().add(lblNome);

	        nome = new JTextField();
	        nome.setBounds(128, 47, 360, 17);
	        this.getContentPane().add(nome);
	        nome.setColumns(10);

	        JLabel lblTelefone = new JLabel("Telefone:");
	        lblTelefone.setBounds(30, 128, 70, 15);
	        this.getContentPane().add(lblTelefone);

	        fone = new JTextField();
	        fone.setBounds(194, 127, 117, 17);
	        this.getContentPane().add(fone);
	        fone.setColumns(10);

	        JLabel lblEmail = new JLabel("E-mail:");
	        lblEmail.setBounds(30, 161, 70, 15);
	        this.getContentPane().add(lblEmail);

	        email = new JTextField();
	        email.setBounds(128, 161, 360, 19);
	        this.getContentPane().add(email);
	        email.setColumns(10);

	        JSeparator separator = new JSeparator();
	        separator.setBounds(30, 202, 556, 2);
	        this.getContentPane().add(separator);
	       
	        JLabel lblCpf = new JLabel("CPF:");
	        lblCpf.setBounds(30, 89, 70, 15);
	        getContentPane().add(lblCpf);
	       
	        cpf = new JTextField();
	        cpf.setBounds(128, 87, 182, 19);
	        getContentPane().add(cpf);
	        cpf.setColumns(10);
	       
	        ddd = new JTextField();
	        ddd.setColumns(10);
	        ddd.setBounds(128, 127, 39, 17);
	        getContentPane().add(ddd);
	       
	        label = new JLabel("(");
	        label.setBounds(116, 128, 13, 15);
	        getContentPane().add(label);
	       
	        label_1 = new JLabel(")");
	        label_1.setBounds(174, 128, 13, 15);
	        getContentPane().add(label_1);
	        
	        JLabel lblId = new JLabel("Id");
	        lblId.setBounds(30, 12, 70, 15);
	        getContentPane().add(lblId);
	        
	        id = new JTextField();
	        id.setBounds(128, 16, 114, 19);
	        getContentPane().add(id);
	        id.setColumns(10);
	        
	        JButton btnCancelar = new JButton("Cancelar");
	        btnCancelar.setBounds(174, 215, 99, 23);
	        getContentPane().add(btnCancelar);
	        	
	        btnCancelar.setActionCommand("cancelar");
	        //cliando nos botões ele chama automaticamente o metodo action perfomace
	        btnCancelar.addActionListener(this);
	        
	        JButton btnCadastrar = new JButton("Cadastrar");
	        btnCadastrar.setBounds(330, 215, 99, 23);
	        getContentPane().add(btnCadastrar);

	        btnCadastrar.setActionCommand("cadastrar");
	        //cliando nos botões ele chama automaticamente o metodo action perfomace
	        btnCadastrar.addActionListener(this);
	    }

		@Override
		public void actionPerformed(ActionEvent e) {
			//System.out.println(e.getActionCommand());
			if (e.getActionCommand().equals("cancelar")){
				System.out.println("Cancelou operacao");
			}else
				System.out.println(this.nome.getText());
			
		}
}
