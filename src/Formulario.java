import java.awt.*;
import javax.swing.*;

public class Formulario extends JFrame {
    private final JTextField nameField;
    private final JTextField addressField;
    private final JTextField cityField;
    private final JComboBox<String> stateComboBox;
    private final JTextField phoneField;
    private final JRadioButton activeRadioButton;
    private final JRadioButton inactiveRadioButton;
    private final JButton saveButton;

    public Formulario() {
        setTitle("Cadastrar Clientes");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 2));

        // Create form fields
        JLabel nameLabel = new JLabel("Nome Completo:");
        nameField = new JTextField();

        JLabel addressLabel = new JLabel("Endereço:");
        addressField = new JTextField();

        JLabel cityLabel = new JLabel("Cidade:");
        cityField = new JTextField();

        JLabel stateLabel = new JLabel("Estado:");
        stateComboBox = new JComboBox<>(new String[]{"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"});

        JLabel phoneLabel = new JLabel("Telefone:");
        phoneField = new JTextField();

        JLabel statusLabel = new JLabel("Status:");
        activeRadioButton = new JRadioButton("Ativo");
        inactiveRadioButton = new JRadioButton("Inativo");
        ButtonGroup statusGroup = new ButtonGroup();
        statusGroup.add(activeRadioButton);
        statusGroup.add(inactiveRadioButton);

        saveButton = new JButton("Gravar Dados");

        // Add components to the frame
        add(nameLabel);
        add(nameField);
        add(addressLabel);
        add(addressField);
        add(cityLabel);
        add(cityField);
        add(stateLabel);
        add(stateComboBox);
        add(phoneLabel);
        add(phoneField);
        add(statusLabel);
        add(activeRadioButton);
        add(new JLabel()); // Empty cell
        add(inactiveRadioButton);
        add(saveButton);

        // Add action listener for the button
        saveButton.addActionListener(e -> validateFields());
    }

    private void validateFields() {
        StringBuilder errorMessage = new StringBuilder("Por favor, preencha os seguintes campos:\n");
        boolean hasError = false;

        if (nameField.getText().isEmpty()) {
            errorMessage.append("- Nome Completo\n");
            hasError = true;
        }
        if (addressField.getText().isEmpty()) {
            errorMessage.append("- Endereço\n");
            hasError = true;
        }
        if (cityField.getText().isEmpty()) {
            errorMessage.append("- Cidade\n");
            hasError = true;
        }
        if (phoneField.getText().isEmpty()) {
            errorMessage.append("- Telefone\n");
            hasError = true;
        }
        if (stateComboBox.getSelectedItem() == null) {
            errorMessage.append("- Estado\n");
            hasError = true;
        }
        if (!activeRadioButton.isSelected() && !inactiveRadioButton.isSelected()) {
            errorMessage.append("- Status\n");
            hasError = true;
        }

        if (hasError) {
            JOptionPane.showMessageDialog(this, errorMessage.toString(), "Erro de Validação", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Dados gravados com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Formulario formulario = new Formulario();
            formulario.setVisible(true);
        });
    }
}