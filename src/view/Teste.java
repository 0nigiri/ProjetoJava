package view;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Teste {

    private final JFrame jf;
    private final List<JLabel> lista;
    private final List<JTextField> listaJTextField;

    public static void main(String[] args) {
        EventQueue.invokeLater(CadastroFuncionario::new);
    }

    public void CadastroFuncionario() {
        lista = new ArrayList<>();

        jf = new JFrame("Teste");
        jf.setBounds(10, 10, 700, 700);
        jf.setLayout(null);

        //Labels dinamicos
/*        JButton bt = new JButton("Novo label");
        jf.add(bt);
        bt.setBounds(10, 10, 100, 30);

        bt.addActionListener(e -> adicionarLabel());
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);
        //Fim area labels dinamicos
  */      
        //Inputs dinamicos
        JButton btNovoFilho = new JButton("+ Acrescentar filho");
        jf.add(btNovoFilho);
        btNovoFilho.setBounds(200, 200, 100, 30);

        listaJTextField = new ArrayList<>();

        btNovoFilho.addActionListener(e -> adicionarInputNovoFilho());
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);
        //Fim area Inputs dinamicos
    }

    public void adicionarLabel() {
        int n = lista.size() + 1;
        String name = "cor " + n;
        JLabel label = new JLabel(name);
        jf.add(label);
        label.setBounds(10, n * 20 + 20, 150, 20);
        lista.add(label);
    }
    
    public void adicionarInputNovoFilho() {
        int n = listaJTextField.size() + 1;
        
        JTextField jTextField = new JTextField();
        jf.add(jTextField);
        jTextField.setBounds(10, n * 20 + 20, 150, 20);
        listaJTextField.add(jTextField);
    }
}