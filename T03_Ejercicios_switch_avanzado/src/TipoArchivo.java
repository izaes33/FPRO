/* **Objetivo:** Crear un programa que identifique el tipo de archivo según su extensión.
**Requisitos:**
1. Declara una variable `String extension` (por ejemplo: "jpg", "pdf", "txt", "mp3").
2. Usa un `switch` para agrupar extensiones similares: Imágenes (jpg, png, gif), Documentos (pdf, doc, txt), Audio (mp3, wav), Video (mp4, avi).
3. Muestra el tipo de archivo y el programa recomendado para abrirlo. */

public class TipoArchivo {

    public void analizador (String extension){

        String tipo;
        String programa;

        switch (extension.toLowerCase()) {

            // Imágenes
            case "jpg", "png", "gif" -> {
                tipo = "Imagen";
                programa = "Visor de fotos o cualquier editor de imágenes";
            }

            // Documentos
            case "pdf", "doc", "txt" -> {
                tipo = "Documento";
                programa = "Adobe Reader, Word o Bloc de notas";
            }

            // Audio
            case "mp3", "wav" -> {
                tipo = "Audio";
                programa = "Reproductor de música";
            }

            // Video
            case "mp4", "avi" -> {
                tipo = "Video";
                programa = "VLC Media Player o cualquier reproductor de video";
            }

            default -> {
                tipo = "Desconocido";
                programa = "No hay programa recomendado";
            }
        }

        System.out.println("Extensión: ." + extension);
        System.out.println("Tipo de archivo: " + tipo);
        System.out.println("Programa recomendado: " + programa);
    }
}
