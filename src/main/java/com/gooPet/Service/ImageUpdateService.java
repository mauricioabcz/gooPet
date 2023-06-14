/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gooPet.Service;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author mauricio.rodrigues
 */
public class ImageUpdateService {
    
    private static ImageUpdateService ImageUpdateService;
    
    private ImageUpdateService() {
        
    }
    
    public static ImageUpdateService getInstance() {
        if(ImageUpdateService.ImageUpdateService == null)
            ImageUpdateService.ImageUpdateService = new ImageUpdateService();
        return ImageUpdateService.ImageUpdateService;
    }
    
    public void ajeitaImagem(String imagePath) {
        try {
            // Carrega a imagem original
            BufferedImage originalImage = ImageIO.read(new File(imagePath));

            // Define a nova largura e altura desejadas
            int newWidth = 470;
            int newHeight = 370;

            // Redimensiona a imagem
            BufferedImage resizedImage = resizeImage(originalImage, newWidth, newHeight);

            // Salva a imagem redimensionada em um arquivo
            File outputFile = new File(".\\images\\Teste2.jpg");
            ImageIO.write(resizedImage, "jpg", outputFile);

            System.out.println("Imagem redimensionada com sucesso!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public BufferedImage resizeImage(BufferedImage originalImage, int newWidth, int newHeight) {
        // Cria um BufferedImage com as dimensões desejadas
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, originalImage.getType());

        // Obtém o objeto Graphics2D para desenhar na imagem redimensionada
        Graphics2D g2d = resizedImage.createGraphics();

        // Aplica renderização suave para melhor qualidade de redimensionamento
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        // Desenha a imagem original redimensionada no BufferedImage
        g2d.drawImage(originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH), 0, 0, null);

        // Libera os recursos do objeto Graphics2D
        g2d.dispose();

        return resizedImage;
    }
    
}
