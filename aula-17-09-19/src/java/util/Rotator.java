package util;

public class Rotator {
    
    private int ponteiroImagem;
    private String[] image;
    private String link[] = {
        "https://www.amazon.com/",
        "https://www.google.com/",
        "https://www.w3schools.com/"
    };
    
    public Rotator(){
        ponteiroImagem = 0;
        image = new String[3];
        image[0] = "https://img.elo7.com.br/product/zoom/279D39E/big-poster-game-the-witcher-3-lo39-tamanho-90x60-cm-posters-de-jogos.jpg";
        image[1] = "https://images-na.ssl-images-amazon.com/images/I/71wlUrbx68L._SY606_.jpg";
        image[2] = "https://http2.mlstatic.com/poster-cartaz-jogo-god-of-war-4-a-60x90cm-D_NQ_NP_924994-MLB27174812425_042018-F.jpg";
    }
    
    public String getImage(){
        return image[ponteiroImagem];
    }
    
    public String getLink(){
        return link[ponteiroImagem];
    }
    public void nextAd(){
        if(ponteiroImagem == 2)
            ponteiroImagem = 0;
        else
            ponteiroImagem++;
    }
}
