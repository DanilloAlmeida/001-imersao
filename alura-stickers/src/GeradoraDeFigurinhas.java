import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.awt.*;

import java.net.URL;
import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

    public void cria(InputStream inputStream, String nomeArquivoSaida) throws Exception{

        //LEITURA DA IMAGEM

        // BufferedImage imagemOriginal = ImageIO.read(new File("entrada/filme.jpg"));
        // MELHORANDO COM INPUTSTREAM
        // InputStream inputStream = new URL(
        //     "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_1.jpg"
        // ).openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        //CRIAR NOVA IMAGEM TRANSPARENTE E NO TAMANHO
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();

        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);
        

        //CONFIGURANDO A FONTE
        Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 92);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);
        
        // ESCREVER UMA FRASE NA NOVA IMAGEM
        graphics.drawString("TOPZERA", 100, novaAltura - 100);
        // COPIAR A IMAGEM ORIGINAL PARA A NOVA IMAGEM (EM MEMÓRIA

        ImageIO.write(novaImagem, "png", new File(nomeArquivoSaida));

        
    }
    // public static void main(String[] args) throws Exception {
    //     GeradoraDeFigurinhas GDF = new GeradoraDeFigurinhas();
    //     GDF.cria();
    // }
}
