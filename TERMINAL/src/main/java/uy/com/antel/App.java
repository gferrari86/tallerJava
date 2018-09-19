package uy.com.antel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String args[]){

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        IAdminSolicitud adminSolicitud = IAdminSolicitudImp.getInstancia();

        String comando = null;

        do{

            try {
                System.out.print("Ingrese comando -> ");
                comando = entrada.readLine();
                String[] tokens = comando.split("\\s");
                comando = tokens[0];
                switch (comando){
                    case "h":
                    case "H":{
                        System.out.println("H\n" +
                                "◦ despliega una ayuda para el usuario\n" +
                                "V <matriculaVehiculo> <fechaInicioEstacionamiento> <cantidadMinutos>\n" +
                                "◦ Genera una solicitud de venta. Formato fechaInicioEstacionamiento=dd/MM/yyyy:HH:mm \n" +
                                "A <numeroTicket>\n" +
                                "◦ Genera una solicitud para anular el Ticket\n" +
                                "Q\n" +
                                "◦ Termina la ejecución del programa");
                        break;
                    }
                    case "v":
                    case "V":{
                        try {
                            Solicitud nuevaSolicitud = new Solicitud();
                            nuevaSolicitud.setTipoSolicitud(TipoSolicitud.VENTA);
                            nuevaSolicitud.setMatriculaVehiculo(tokens[1]);
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy:HH:mm");
                            Date fechaInicioEstacionamiento = sdf.parse(tokens[2]);
                            nuevaSolicitud.setFechaInicioEstacionamiento(fechaInicioEstacionamiento);
                            nuevaSolicitud.setCantidadMinutos(Integer.parseInt(tokens[3]));
                            adminSolicitud.enviarSolicitud(nuevaSolicitud);

                        } catch (ParseException e) {
                            System.out.println("Fecha Invalida");
                        }

                        break;
                    }
                    case "a":
                    case "A":{
                        Solicitud nuevaSolicitud = new Solicitud();
                        nuevaSolicitud.setTipoSolicitud(TipoSolicitud.ANULACION);
                        nuevaSolicitud.setNumeroTicketAnulacion(tokens[1]);
                        adminSolicitud.enviarSolicitud(nuevaSolicitud);
                        break;
                    }
                    case "q":
                    case "Q":
                    case "":
                        break;
                    default:
                        System.out.println("Error: Comando inválido");
                        break;


                }
            }
            catch (IOException e){

                e.printStackTrace();

            }catch (NumberFormatException | ArrayIndexOutOfBoundsException e){
                System.out.println("Comando inválido");
                //e.printStackTrace();

            }


        }while(!comando.equalsIgnoreCase("Q"));
    }
}
