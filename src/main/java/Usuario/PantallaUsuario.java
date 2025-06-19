/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Usuario;

import Arena.Mapa;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author gambo
 */
public class PantallaUsuario extends javax.swing.JFrame {
    private static final String PROMPT = ">> "; // Símbolo de prompt
    private boolean isEditingPrompt = false;
    private int lastPromptPosition = 0; // Guarda la posición del último prompt
    
    private ClienteController controlador;
    
    /**
     * Creates new form PantallaCliente
     */
    public PantallaUsuario() {
        initComponents();
        setTitle("DronAttack");
        setLocationRelativeTo(null);
        
        // Configurar el JTextArea como terminal
        configurarTerminal();
        
        this.controlador = new ClienteController(this, "Jugador1");
        
//        entradaComandos.addActionListener(e -> {
//            String texto = entradaComandos.getText().trim();
//            controlador.procesarComando(texto);
//            entradaComandos.setText("");
//        });
    }
    
    private void configurarTerminal() {
        comandos.setFont(new Font("Consolas", Font.PLAIN, 14));
        comandos.setBackground(Color.BLACK);
        comandos.setForeground(Color.GREEN);
        comandos.setText(PROMPT);
        lastPromptPosition = PROMPT.length();

        ((AbstractDocument)comandos.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
                if (offset < lastPromptPosition) {
                    return; // No permitir borrar antes del prompt
                }
                super.remove(fb, offset, length);
            }

            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (offset < lastPromptPosition) {
                    return; // No permitir insertar antes del prompt
                }
                super.insertString(fb, offset, string, attr);
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (offset < lastPromptPosition) {
                    return; // No permitir reemplazar antes del prompt
                }
                super.replace(fb, offset, length, text, attrs);
            }
        });

        comandos.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    e.consume();
                    String fullText = comandos.getText();
                    // Asegurarnos de que solo tomamos el texto después del último prompt
                    String comando = fullText.substring(lastPromptPosition).trim();
                    System.out.println("comand" + comando);
                    controlador.procesarComando(comando);
                }
            }
        });
    }
    
    private void procesarComandoTerminal() {
        String fullText = comandos.getText();
        // Asegurarnos de que solo tomamos el texto después del último prompt
        String comando = fullText.substring(lastPromptPosition).trim();

        // Procesar el comando con tu controlador
        String respuesta = "[Sistema] Ejecutado: " + comando; // Ejemplo

        // Mostrar respuesta y nuevo prompt
        comandos.append("\n" + respuesta + "\n" + PROMPT);
        lastPromptPosition = comandos.getText().length();
        comandos.setCaretPosition(lastPromptPosition);
    }

    // Añadir estos métodos:
    public void mostrarRespuestaComando(String respuesta) {
        comandos.append("\n" + respuesta + "\n" + PROMPT);
        lastPromptPosition = comandos.getText().length();
        comandos.setCaretPosition(lastPromptPosition);
    }
    
    public void actualizarMapaPropio(Mapa mapa) {
        // Implementar lógica para mostrar tu mapa
    }
    
    public void actualizarMapaEnemigo(Mapa mapa) {
        // Implementar con niebla de guerra
    }
    
    public void actualizarEstadisticas(int energia, int turno, int estructurasActivas) {
        // Actualizar panel de estadísticas
    }
    
    public void mostrarNotificacion(String mensaje) {
        // Para mensajes del Observer
        comandos.append("[NOTIFICACIÓN] " + mensaje + "\n");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        salidaChat = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        comandos = new javax.swing.JTextArea();
        mapaJugadorPrincipalPnl = new javax.swing.JPanel();
        mapaJugadorSecundarioPnl = new javax.swing.JPanel();
        chatLbl = new javax.swing.JLabel();
        timerLbl = new javax.swing.JLabel();
        commandLbl = new javax.swing.JLabel();
        estadisticasPnl = new javax.swing.JPanel();
        estadisticasLbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        salidaChat.setColumns(20);
        salidaChat.setRows(5);
        salidaChat.setFocusable(false);
        jScrollPane1.setViewportView(salidaChat);

        comandos.setColumns(20);
        comandos.setRows(5);
        jScrollPane2.setViewportView(comandos);

        mapaJugadorPrincipalPnl.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout mapaJugadorPrincipalPnlLayout = new javax.swing.GroupLayout(mapaJugadorPrincipalPnl);
        mapaJugadorPrincipalPnl.setLayout(mapaJugadorPrincipalPnlLayout);
        mapaJugadorPrincipalPnlLayout.setHorizontalGroup(
            mapaJugadorPrincipalPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        mapaJugadorPrincipalPnlLayout.setVerticalGroup(
            mapaJugadorPrincipalPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        mapaJugadorSecundarioPnl.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout mapaJugadorSecundarioPnlLayout = new javax.swing.GroupLayout(mapaJugadorSecundarioPnl);
        mapaJugadorSecundarioPnl.setLayout(mapaJugadorSecundarioPnlLayout);
        mapaJugadorSecundarioPnlLayout.setHorizontalGroup(
            mapaJugadorSecundarioPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
        mapaJugadorSecundarioPnlLayout.setVerticalGroup(
            mapaJugadorSecundarioPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        chatLbl.setBackground(new java.awt.Color(255, 255, 255));
        chatLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chatLbl.setText("~~~~~~~~~~~~~~CHAT~~~~~~~~~~~~~~");
        chatLbl.setOpaque(true);

        timerLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timerLbl.setText("Tiempo: 00:00");

        commandLbl.setBackground(new java.awt.Color(255, 255, 255));
        commandLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        commandLbl.setText("~~~~~~~~~~~~~~COMMAND~~~~~~~~~~~~~~");
        commandLbl.setOpaque(true);

        estadisticasPnl.setBackground(new java.awt.Color(204, 204, 204));

        estadisticasLbl.setBackground(new java.awt.Color(153, 204, 255));
        estadisticasLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        estadisticasLbl.setText("Estadisticas");
        estadisticasLbl.setOpaque(true);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("jLabel2");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("jLabel2");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("jLabel2");

        javax.swing.GroupLayout estadisticasPnlLayout = new javax.swing.GroupLayout(estadisticasPnl);
        estadisticasPnl.setLayout(estadisticasPnlLayout);
        estadisticasPnlLayout.setHorizontalGroup(
            estadisticasPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(estadisticasPnlLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(estadisticasLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        estadisticasPnlLayout.setVerticalGroup(
            estadisticasPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(estadisticasPnlLayout.createSequentialGroup()
                .addComponent(estadisticasLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        estadisticasLbl.getAccessibleContext().setAccessibleName("Estadísticas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(mapaJugadorPrincipalPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(chatLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mapaJugadorSecundarioPnl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(timerLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(estadisticasPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(commandLbl)
                        .addContainerGap(201, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(mapaJugadorPrincipalPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mapaJugadorSecundarioPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(estadisticasPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timerLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chatLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                    .addComponent(commandLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel chatLbl;
    private javax.swing.JTextArea comandos;
    private javax.swing.JLabel commandLbl;
    private javax.swing.JLabel estadisticasLbl;
    private javax.swing.JPanel estadisticasPnl;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel mapaJugadorPrincipalPnl;
    private javax.swing.JPanel mapaJugadorSecundarioPnl;
    private javax.swing.JTextArea salidaChat;
    private javax.swing.JLabel timerLbl;
    // End of variables declaration//GEN-END:variables
}
