package ma.ismo.crjj.ihm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Convertisseur extends JFrame {

	private JPanel contentPane;
	private JTextField txtDevise;
	private JTextField txtTaux;
	private JTextField txtEuro;
	private JButton btnFracToEuro;
	private JButton btnEuroToFranc;
	private JTextField txtDeviseValue;
	private JButton btnQuiter;
	private JButton btnValiderDevise;
	private JButton btnValiderTaux;
	private JLabel lblDeviseValue;

	// Global Var to stock taux value:
	double tauxValue = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Convertisseur frame = new Convertisseur();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Convertisseur() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "R\u00E9glages",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(68, 36, 473, 182);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lbl1 = new JLabel("Devise");
		lbl1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl1.setBounds(39, 50, 85, 32);
		panel.add(lbl1);

		JLabel lblTaux = new JLabel("Taux");
		lblTaux.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTaux.setBounds(52, 89, 55, 32);
		panel.add(lblTaux);

		txtDevise = new JTextField();
		txtDevise.setBounds(126, 56, 165, 25);
		panel.add(txtDevise);
		txtDevise.setColumns(10);

		txtTaux = new JTextField();
		txtTaux.setColumns(10);
		txtTaux.setBounds(126, 95, 165, 25);
		txtTaux.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				try {
					Double.parseDouble(txtTaux.getText() + evt.getKeyChar());
				} catch (Exception e) {
					evt.consume();

				}

			}
		});
		panel.add(txtTaux);

		btnValiderDevise = new JButton("Valider");
		btnValiderDevise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtDevise.getText().equals("")) {
					JOptionPane.showConfirmDialog(null, "Try to fill the 'Devise' Text!", "Warning",
							JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE);
				} else {
					lblDeviseValue.setText(txtDevise.getText());
				}
			}
		});
		btnValiderDevise.setBounds(338, 56, 97, 25);
		panel.add(btnValiderDevise);

		btnValiderTaux = new JButton("Valider");
		btnValiderTaux.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtTaux.getText().equals("")) {
					JOptionPane.showConfirmDialog(null, "Try to fill the 'Taux' Value!", "Warning",
							JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE);
				} else
					tauxValue = Double.valueOf(txtTaux.getText());

			}
		});
		btnValiderTaux.setBounds(338, 95, 97, 25);
		panel.add(btnValiderTaux);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Conversion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(68, 255, 473, 182);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		lblDeviseValue = new JLabel("");
		lblDeviseValue.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDeviseValue.setBounds(59, 61, 69, 21);
		panel_1.add(lblDeviseValue);

		JLabel lblFranc = new JLabel("\u20AC");
		lblFranc.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblFranc.setBounds(354, 61, 31, 21);
		panel_1.add(lblFranc);

		txtDeviseValue = new JTextField();
		txtDeviseValue.setBounds(25, 95, 145, 32);
		panel_1.add(txtDeviseValue);
		txtDeviseValue.setColumns(10);
		txtDeviseValue.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				try {
					Double.parseDouble(txtDeviseValue.getText() + evt.getKeyChar());
				} catch (Exception e) {
					evt.consume();

				}

			}
		});

		txtEuro = new JTextField();
		txtEuro.setColumns(10);
		txtEuro.setBounds(298, 95, 145, 32);
		txtEuro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				try {
					Double.parseDouble(txtEuro.getText() + evt.getKeyChar());
				} catch (Exception e) {
					evt.consume();

				}

			}
		});
		panel_1.add(txtEuro);

		btnFracToEuro = new JButton(">>");
		btnFracToEuro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!lblDeviseValue.getText().equals("") && tauxValue != 0) {
					if (!txtDeviseValue.getText().equals("")) {
						double res = Double.valueOf(txtDeviseValue.getText()) / Double.valueOf(txtTaux.getText());
						txtEuro.setText(res + "");
					} else {
						JOptionPane.showConfirmDialog(null,
								"Try to fill the '" + lblDeviseValue.getText() + "' Field !", "Warning",
								JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE);
					}

				} else {
					JOptionPane.showConfirmDialog(null,
							"Try to fill the 'Taux'& 'Devise' Fields or Press 'Valider' if you forgot!", "Warning",
							JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		btnFracToEuro.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnFracToEuro.setBounds(208, 25, 69, 57);
		panel_1.add(btnFracToEuro);

		btnEuroToFranc = new JButton("<<");
		btnEuroToFranc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!lblDeviseValue.getText().equals("") && tauxValue != 0) {

					if (!txtEuro.getText().equals("")) {
						double res = Double.valueOf(txtEuro.getText()) * Double.valueOf(txtTaux.getText());
						txtDeviseValue.setText(res + "");
					} else {
						JOptionPane.showConfirmDialog(null, "Try to fill the '€' Field !", "Warning",
								JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showConfirmDialog(null,
							"Try to fill the 'Taux'& '" + lblDeviseValue.getText()
									+ "' Fields or Press 'Valider' if you forgot!",
							"Warning", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		btnEuroToFranc.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEuroToFranc.setBounds(208, 93, 69, 48);
		panel_1.add(btnEuroToFranc);

		btnQuiter = new JButton("Quiter");
		btnQuiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnQuiter.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnQuiter.setBounds(485, 450, 97, 34);
		contentPane.add(btnQuiter);
	}

}
