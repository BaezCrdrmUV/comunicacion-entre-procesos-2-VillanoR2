import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class Comunicacion {
    public static void main(String[] args) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("/Users/villa/Documents/Git/DesarrolloRed/comunicacion-entre-procesos-2-VillanoR2/Archivo.txt");
        Process process1 = processBuilder.start();
        long pid1 = process1.pid();
        System.out.println(pid1);

        System.out.println("Escribiendo en Archivo");
        String mensaje = "Mensaje 012394392";
        File archivo = new File("Archivo.txt");
        FileWriter escribe = new FileWriter(archivo, true);

        for (int i = 0; i < 10; i++) {
            escribe.write("El proceso: "+ pid1 + " escribio un mensaje: " + mensaje );
        }

        escribe.close();

        LeerArchivo("/Users/villa/Documents/Git/DesarrolloRed/comunicacion-entre-procesos-2-VillanoR2/Archivo.txt");            
    }


    public static String LeerArchivo(String file){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
        try{
            archivo = new File(file);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            
            String linea;
            while ((linea = br.readLine()) != null)
               file = linea;
         } catch (IOException ex) {
            ex.printStackTrace();
         } finally {
            try {
               if (null != fr) {
                  fr.close();
               }
            } catch (IOException ex) {
               ex.printStackTrace();
            }
        }
      return file;
    }
    
}