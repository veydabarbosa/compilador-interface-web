import controller.CompiladorController;
import model.Arquivo;
import service.ArquivoService;
import javax.swing.SwingUtilities;
import view.JanelaPrincipal;

public class main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JanelaPrincipal janela = new JanelaPrincipal();

            CompiladorController controller = new CompiladorController(
                    janela.getEditor(),
                    janela.getAreaMensagens(),
                    janela.getBarraStatus(),
                    new ArquivoService(),
                    new Arquivo()
            );
            controller.registrar(janela.getBarraFerramentas(), janela.getRootPane());

            janela.setVisible(true);
        });
    }
}