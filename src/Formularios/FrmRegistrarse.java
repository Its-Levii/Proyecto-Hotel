/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Formularios;

import java.awt.Image;
import javax.swing.ImageIcon;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

import proyectohotel.Usuario;

/**
 *
 * @author Usuario
 */
public class FrmRegistrarse extends javax.swing.JFrame {

    /**
     * Creates new form FrmRegistrarse
     */
    String[] ComboGenero = {"Masculino", "Femenino", "Otro"};
    String[] ComboMeses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    Map<String, String[]> ComboDepartamentos = new HashMap<>();
    public FrmRegistrarse() {
        initComponents();
        llenarDepartamentos();
        llenarItems();
    }
    public void llenarDepartamentos(){
        ComboDepartamentos.put("AMAZONAS" , new String[]{"El Encanto", "La Chorrera", "La Pedrera", "La Victoria", "Leticia", "Miriti - Paraná",
            "Puerto Alegria", "Puerto Arica", "Puerto Nariño", "Puerto Santander", "Tarapacá"});
        ComboDepartamentos.put("ANTIOQUIA", new String[]{"Abejorral", "Abriaquí", "Alejandría", "Amagá", "Amalfi", "Andes", "Angelópolis", "Angostura", "Anorí",
            "Anzá", "Apartadó", "Arboletes", "Argelia", "Armenia", "Barbosa", "Bello", "Belmira", "Betania",
            "Betulia", "Briceño", "Buriticá", "Cáceres", "Caicedo", "Caldas", "Campamento", "Cañasgordas", "Caracolí",
            "Caramanta", "Carepa", "Carolina del Príncipe", "Caucasia", "Chigorodó", "Cisneros", "Cocorná", "Concepción",
            "Concordia", "Copacabana", "Dabeiba", "Donmatías", "Ebéjico", "El Bagre", "El Carmen de Viboral", "El Peñol",
            "El Retiro", "El Santuario", "Entrerríos", "Envigado", "Fredonia", "Frontino", "Giraldo", "Girardota",
            "Gómez Plata", "Granada", "Guadalupe", "Guarne", "Guatapé", "Heliconia", "Hispania", "Itagüí", "Ituango",
            "Jardín", "Jericó", "La Ceja", "La Estrella", "La Pintada", "La Unión", "Liborina", "Maceo", "Marinilla",
            "Medellín", "Montebello", "Murindó", "Mutatá", "Nariño", "Nechí", "Necoclí", "Olaya", "Peque", "Pueblorrico",
            "Puerto Berrío", "Puerto Nare", "Puerto Triunfo", "Remedios", "Retiro", "Rionegro", "Sabanalarga", "Sabaneta",
            "Salgar", "San Andrés de Cuerquia", "San Carlos", "San Francisco", "San Jerónimo", "San José de la Montaña",
            "San Juan de Urabá", "San Luis", "San Pedro de los Milagros", "San Pedro de Urabá", "San Rafael",
            "San Roque", "San Vicente", "Santa Bárbara", "Santa Fe de Antioquia", "Santa Rosa de Osos", "Santo Domingo",
            "Segovia", "Sonsón", "Sopetrán", "Támesis", "Tarazá", "Tarso", "Titiribí", "Toledo", "Turbo", "Uramita",
            "Urrao", "Valdivia", "Valparaíso", "Vegachí", "Venecia", "Vigía del Fuerte", "Yalí", "Yarumal", "Yolombó",
            "Yondó", "Zaragoza"});
        ComboDepartamentos.put("ARAUCA", new String[] {"Arauca", "Arauquita", "Cravo Norte", "Fortul", "Puerto Rondón", "Saravena", "Tame"});
        ComboDepartamentos.put("ATLANTICO", new String[] {"Baranoa", "Barranquilla", "Campo de la Cruz", "Candelaria", "Galapa", "Juan de Acosta",
            "Luruaco", "Malambo", "Manatí", "Palmar de Varela", "Piojó", "Polonuevo", "Ponedera",
            "Puerto Colombia", "Repelón", "Sabanagrande", "Sabanalarga", "Santa Lucía", "Santo Tomás",
            "Soledad", "Suán", "Tubará", "Usiacurí"});
        ComboDepartamentos.put("BOLIVAR", new String[] {    "Achí", "Altos del Rosario", "Arenal", "Arjona", "Arroyohondo", "Barranco de Loba", "Brazuelo de Papayal",
            "Calamar", "Cantagallo", "Cartagena de Indias", "Cicuco", "Clemencia", "Córdoba", "El Carmen de Bolívar",
            "El Guamo", "El Peñón", "Hatillo de Loba", "Magangué", "Mahates", "Margarita", "María la Baja",
            "Montecristo", "Morales", "Norosí", "Pinillos", "Regidor", "Río Viejo", "San Cristóbal", "San Estanislao",
            "San Fernando", "San Jacinto", "San Jacinto del Cauca", "San Juan Nepomuceno", "San Martín de Loba",
            "San Pablo", "Santa Catalina", "Santa Rosa", "Santa Rosa del Sur", "Simití", "Soplaviento", "Talaigua Nuevo",
            "Tiquisio", "Turbaco", "Turbana", "Villanueva", "Zambrano"});
        ComboDepartamentos.put("BOYACA", new String[] {"Almeida", "Aquitania", "Arcabuco", "Belén", "Berbeo", "Betéitiva", "Boavita", "Boyacá", "Briceño",
            "Buena Vista", "Busbanzá", "Caldas", "Campohermoso", "Cerinza", "Chinavita", "Chiquinquirá", "Chíquiza",
            "Chiscas", "Chita", "Chitaraque", "Chivatá", "Chivor", "Ciénega", "Cómbita", "Coper", "Corrales", "Covarachía",
            "Cubará", "Cucaita", "Cuítiva", "Duitama", "El Cocuy", "El Espino", "Firavitoba", "Floresta", "Gachantivá",
            "Gámeza", "Garagoa", "Guacamayas", "Guateque", "Guayatá", "Güicán", "Iza", "Jenesano", "Jericó", "La Capilla",
            "La Uvita", "La Victoria", "Labranzagrande", "Macanal", "Maripí", "Miraflores", "Mongua", "Monguí", "Moniquirá",
            "Motavita", "Muzo", "Nobsa", "Nuevo Colón", "Oicatá", "Otanche", "Pachavita", "Páez", "Paipa", "Pajarito",
            "Panqueba", "Pauna", "Paya", "Paz de Río", "Pesca", "Pisba", "Puerto Boyacá", "Quípama", "Ramiriquí", "Ráquira",
            "Rondón", "Saboyá", "Sáchica", "Samacá", "San Eduardo", "San José de Pare", "San Luis de Gaceno",
            "San Mateo", "San Miguel de Sema", "San Pablo de Borbur", "Santa María", "Santa Rosa de Viterbo",
            "Santa Sofía", "Santana", "Sativanorte", "Sativasur", "Siachoque", "Soatá", "Socha", "Socotá", "Sogamoso",
            "Somondoco", "Sora", "Sotaquirá", "Soracá", "Susacón", "Sutamarchán", "Sutatenza", "Tasco", "Tenza", "Tibaná",
            "Tibasosa", "Tinjacá", "Tipacoque", "Toca", "Togüí", "Tópaga", "Tota", "Tunja", "Tununguá", "Turmequé",
            "Tuta", "Tutazá", "Úmbita", "Ventaquemada", "Villa de Leyva", "Viracachá", "Zetaquira"});
        ComboDepartamentos.put("CALDAS", new String[] {"Aguadas", "Anserma", "Aranzazu", "Belalcázar", "Chinchiná", "Filadelfia", "La Dorada", "La Merced",
            "Manizales", "Manzanares", "Marmato", "Marquetalia", "Marulanda", "Neira", "Norcasia", "Pácora",
            "Palestina", "Pensilvania", "Riosucio", "Risaralda", "Salamina", "Samaná", "San José", "Supía",
            "Victoria", "Villamaría", "Viterbo"});
        ComboDepartamentos.put("CAQUETA", new String[] {"Albania", "Belén de los Andaquíes", "Cartagena del Chairá", "Curillo", "El Doncello",
            "El Paujil", "Florencia", "La Montañita", "Milán", "Morelia", "Puerto Rico", "San José del Fragua",
            "San Vicente del Caguán", "Solano", "Solita", "Valparaíso"});
        ComboDepartamentos.put("CASANARE", new String[] {});
        ComboDepartamentos.put("CAUCA", new String[] {
            "Popayán", "Almaguer", "Argelia", "Balboa", "Bolívar", "Buenos Aires",
            "Cajibío", "Caldono", "Caloto", "Corinto", "El Tambo", "Florencia",
            "Guachené", "Guapi", "Inzá", "Jambaló", "La Sierra", "La Vega",
            "López de Micay", "Mercaderes", "Miranda", "Morales", "Padilla", "Páez",
            "Patía", "Piamonte", "Piendamó", "Puerto Tejada", "Puracé", "Rosas",
            "San Sebastián", "Santander de Quilichao", "Santa Rosa", "Silvia",
            "Sotará", "Suárez", "Sucre", "Timbío", "Timbiquí", "Toribío", "Totoró",
            "Villa Rica"
        });
        ComboDepartamentos.put("CESAR", new String[] {
            "Aguachica", "Agustín Codazzi", "Astrea", "Becerril", "Bosconia", "Chimichagua",
            "Chiriguaná", "Curumaní", "El Copey", "El Paso", "Gamarra", "González",
            "La Gloria", "La Jagua de Ibirico", "La Paz", "Manaure Balcón del Cesar",
            "Pailitas", "Pelaya", "Pueblo Bello", "Río de Oro", "San Alberto",
            "San Diego", "San Martín", "Tamalameque", "Valledupar"
        });
        ComboDepartamentos.put("CHOCO", new String[] {
            "Acandí", "Alto Baudó", "Atrato", "Bagadó", "Bahía Solano", "Bajo Baudó",
            "Bojayá", "Cantón de San Pablo", "Carmen del Darién", "Condoto", "El Carmen de Atrato",
            "El Litoral del San Juan", "Istmina", "Juradó", "Lloró", "Medio Atrato",
            "Medio Baudó", "Medio San Juan", "Nóvita", "Nuquí", "Quibdó", "Río Iró",
            "Río Quito", "Riosucio", "San José del Palmar", "Sipí", "Tadó", "Unguía", "Unión Panamericana"
        });
        ComboDepartamentos.put("CORDOBA", new String[] {
            "Ayapel", "Buenavista", "Canalete", "Cereté", "Chimá", "Chinú",
            "Ciénaga de Oro", "Cotorra", "La Apartada", "Los Córdobas", "Momil",
            "Montelíbano", "Montería", "Moñitos", "Planeta Rica", "Pueblo Nuevo",
            "Puerto Escondido", "Puerto Libertador", "Purísima", "Sahagún",
            "San Andrés de Sotavento", "San Antero", "San Bernardo del Viento",
            "San Carlos", "San José de Uré", "San Pelayo", "Tierralta", "Tuchín",
            "Valencia"
        });
        ComboDepartamentos.put("CUNDINAMARCA", new String[] {
            "Agua de Dios", "Albán", "Anapoima", "Anolaima", "Arbeláez", "Beltrán",
            "Bituima", "Bojacá", "Cabrera", "Cachipay", "Cajicá", "Caparrapí",
            "Cáqueza", "Carmen de Carupa", "Chaguaní", "Chipaque", "Choachí",
            "Chocontá", "Cogua", "Cota", "Cucunubá", "El Colegio", "El Peñón",
            "El Rosal", "Facatativá", "Fómeque", "Fosca", "Funza", "Fúquene",
            "Fusagasugá", "Gachalá", "Gachancipá", "Gachetá", "Gama", "Girardot",
            "Granada", "Guachetá", "Guaduas", "Guasca", "Guataquí", "Guatavita",
            "Guayabal de Síquima", "Guasca", "Guayabetal", "Gutiérrez", "Jerusalén",
            "Junín", "La Calera", "La Mesa", "La Palma", "La Peña", "La Vega",
            "Lenguazaque", "Machetá", "Madrid", "Manta", "Medina", "Mosquera",
            "Nariño", "Nemocón", "Nilo", "Nimaima", "Nocaima", "Pacho", "Paime",
            "Pandi", "Paratebueno", "Pasca", "Puerto Salgar", "Quebradanegra",
            "Quetame", "Quipile", "Apulo", "Ricaurte", "San Antonio del Tequendama",
            "San Bernardo", "San Cayetano", "San Francisco", "San Juan de Río Seco",
            "Sasaima", "Sesquilé", "Sibaté", "Silvania", "Simijaca", "Soacha",
            "Sopó", "Subachoque", "Suesca", "Supatá", "Susa", "Sutatausa",
            "Tabio", "Tausa", "Tena", "Tenjo", "Tibacuy", "Tibirita", "Tocaima",
            "Tocancipá", "Topaipí", "Ubala", "Ubalá", "Ubaque", "Une", "Útica",
            "Venecia", "Vergara", "Vianí", "Villagómez", "Villapinzón", "Villeta",
            "Viotá", "Yacopí", "Zipacón", "Zipaquirá"
        });
        ComboDepartamentos.put("GUAINIA", new String[] {
            "Barranco Minas", "Inírida", "Mapiripana", "San Felipe", "Puerto Colombia", "Cacahual"
        });
        ComboDepartamentos.put("GUAVIARE", new String[] {
            "Calamar", "El Retorno", "Miraflores", "San José del Guaviare"
        });
        ComboDepartamentos.put("HUILA", new String[] {
            "Acevedo", "Agrado", "Aipe", "Algeciras", "Altamira", "Baraya", "Campoalegre",
            "Colombia", "Elías", "Garzón", "Gigante", "Guadalupe", "Hobo", "Íquira",
            "Isnos", "La Argentina", "La Plata", "Nátaga", "Neiva", "Oporapa", "Paicol",
            "Palermo", "Palestina", "Pital", "Pitalito", "Rivera", "Saladoblanco",
            "San Agustín", "Santa María", "Suaza", "Tarqui", "Tello", "Teruel",
            "Tesalia", "Timaná", "Villavieja", "Yaguará"
        });
        ComboDepartamentos.put("LA GUAJIRA", new String[] {
            "Albania", "Barrancas", "Dibulla", "Distracción", "El Molino", "Fonseca",
            "Hatonuevo", "La Jagua del Pilar", "Maicao", "Manaure", "Riohacha", "Urumita"
        });
        ComboDepartamentos.put("MAGDALENA", new String[] {
            "Algarrobo", "Aracataca", "Ariguaní", "Cerro de San Antonio", "Chibolo",
            "Ciénaga", "Concordia", "El Banco", "El Piñón", "El Retén", "Fundación",
            "Guamal", "Nueva Granada", "Pedraza", "Pijiño del Carmen", "Pivijay",
            "Plato", "Pueblo Viejo", "Remolino", "Sabanas de San Ángel", "Salamina",
            "San Sebastián de Buenavista", "Santa Ana", "Santa Bárbara de Pinto",
            "Santa Marta", "Sitionuevo", "Tenerife", "Zapayán", "Zona Bananera"
        });
        ComboDepartamentos.put("META", new String[] {
            "Acacías", "Barranca de Upía", "Cabuyaro", "Castilla la Nueva", "Cubarral",
            "Cumaral", "El Calvario", "El Castillo", "El Dorado", "Fuente de Oro", "Granada",
            "Guamal", "Mapiripán", "Mesetas", "La Macarena", "Uribe", "Lejanías", "Puerto Concordia",
            "Puerto Gaitán", "Puerto López", "Puerto Lleras", "Puerto Rico", "Restrepo",
            "San Carlos de Guaroa", "San Juan de Arama", "San Juanito", "San Martín",
            "Vista Hermosa", "Villavicencio", "Villanueva", "Vistahermosa"
        });
        ComboDepartamentos.put("NARIÑO", new String[] {
            "Albán", "Aldana", "Ancuya", "Arboleda", "Barbacoas", "Belén", "Buesaco",
            "Chachagüí", "Colón", "Consacá", "Contadero", "Córdoba", "Cuaspud",
            "Cumbal", "Cumbitara", "El Charco", "El Peñol", "El Rosario", "El Tablón",
            "El Tambo", "Francisco Pizarro", "Funes", "Guachucal", "Guaitarilla",
            "Gualmatán", "Iles", "Imués", "Ipiales", "La Cruz", "La Florida", "La Llanada",
            "La Tola", "La Unión", "Leiva", "Lináres", "Los Andes", "Magüí", "Mallama",
            "Mosquera", "Nariño", "Olaya Herrera", "Ospina", "Francisco Pizarro",
            "Policarpa", "Potosí", "Providencia", "Puerres", "Pupiales", "Ricaurte",
            "Roberto Payán", "Samaniego", "San Bernardo", "San Lorenzo", "San Pablo",
            "San Pedro de Cartago", "Santacruz", "Sapuyes", "Taminango", "Tangua",
            "Tumaco", "Túquerres", "Yacuanquer"
        });
        ComboDepartamentos.put("NORTE DE SANTANDER", new String[] {
            "Abrego", "Arboledas", "Bochalema", "Bucarasica", "Cáchira", "Convención",
            "Cucutilla", "Durania", "El Carmen", "El Tarra", "Herrán", "Hacarí",
            "La Esperanza", "La Playa de Belén", "Labateca", "Los Patios", "Lourdes",
            "Mutiscua", "Ocaña", "Pamplona", "Pamplonita", "Puerto Santander",
            "Ragonvalia", "Santiago", "Sardinata", "Silos", "Teorama", "Tibú", "Toledo", "Villa Caro", "Villa del Rosario"
        });
        ComboDepartamentos.put("PUTUMAYO", new String[] {
            "Colón", "Mocoa", "Orito", "Puerto Asís", "Puerto Caicedo", "Puerto Guzmán",
            "Puerto Leguízamo", "San Francisco", "San Miguel", "Santiago", "Valle del Guamuez", "Villagarzón"
        });
        ComboDepartamentos.put("QUINDIO", new String[] {
            "Armenia", "Buenavista", "Calarcá", "Circasia", "Córdoba", "Filandia",
            "La Tebaida", "Montenegro", "Pijao", "Quimbaya", "Salento"
        });
        ComboDepartamentos.put("RISARALDA", new String[] {
            "Apía", "Balboa", "Belén de Umbría", "Dosquebradas", "Guática",
            "La Celia", "La Virginia", "Marsella", "Mistrató", "Pereira",
            "Pueblo Rico", "Quinchía", "Santa Rosa de Cabal", "Santuario"
        });
        ComboDepartamentos.put("SANTANDER", new String[] {
            "Aguada", "Albania", "Aratoca", "Barbosa", "Barichara", "Barrancabermeja",
            "Betulia", "Bolívar", "Bucaramanga", "Cabrera", "California", "Capitanejo",
            "Carcasí", "Cepitá", "Cerrito", "Charalá", "Charta", "Chima", "Chipatá",
            "Cimitarra", "Concepción", "Confines", "Contratación", "Coromoro", "Curití",
            "El Carmen de Chucurí", "El Guacamayo", "El Peñón", "El Playón", "El Socorro",
            "Encino", "Enciso", "Florián", "Floridablanca", "Galán", "Gámbita", "Girón",
            "Guaca", "Guadalupe", "Guapotá", "Guavatá", "Güepsa", "Hato", "Jesús María",
            "Jordán", "La Belleza", "Landázuri", "La Paz", "Lebrija", "Los Santos",
            "Macaravita", "Málaga", "Matanza", "Mogotes", "Molagavita", "Ocamonte",
            "Oiba", "Onzaga", "Palmar", "Palmas del Socorro", "Páramo", "Piedecuesta",
            "Pinchote", "Puente Nacional", "Puerto Parra", "Puerto Wilches", "Rionegro",
            "Sabana de Torres", "San Andrés", "San Benito", "San Gil", "San Joaquín",
            "San Vicente de Chucurí", "Santa Bárbara", "Santa Helena del Opón",
            "Simacota", "Slavic", "Socorro", "Sopetrán", "Suaita", "Suratá",
            "Tona", "Valle de San José", "Vélez", "Vetas", "Villanueva", "Zapatoca"
        });
        ComboDepartamentos.put("SUCRE", new String[] {
            "Buenavista", "Sincelejo", "Caimito", "Colosó", "Corozal",
            "Covarachía", "Galeras", "Guaranda", "La Unión", "Los Palmitos",
            "Majagual", "Morroa", "Ovejas", "Sampués", "San Benito Abad",
            "San Juan de Betulia", "San Marcos", "San Onofre", "San Pedro",
            "Sincé", "Sincelejo", "Sucre", "Tolú", "Toluviejo"
        });

        ComboDepartamentos.put("TOLIMA", new String[] {
            "Alpujarra", "Alvarado", "Ambalema", "Anzoátegui", "Armero",
            "Ataco", "Cajamarca", "Carmen de Apicalá", "Casabianca", "Chaparral",
            "Coello", "Cunday", "Dolores", "Espinal", "Falan", "Flandes",
            "Fresno", "Guamo", "Herveo", "Honda", "Ibagué", "Icononzo",
            "Lérida", "Líbano", "Mariquita", "Melgar", "Murillo", "Natagaima",
            "Ortega", "Palocabildo", "Palestina", "Piedras", "Planadas",
            "Prado", "Purificación", "Rioblanco", "Roncesvalles", "Rovira",
            "Saldaña", "San Antonio", "San Luis", "Santa Isabel", "Suárez",
            "Valle de San Juan", "Venadillo", "Villahermosa", "Villarrica"
        });

        ComboDepartamentos.put("VALLE DEL CAUCA", new String[] {
            "Alcalá", "Andalucía", "Ansermanuevo", "Argelia", "Bolívar",
            "Buenaventura", "Buga", "Bugalagrande", "Caicedonia", "Cali",
            "Calima", "Candelaria", "Cartago", "Dagua", "El Águila", "El Cairo",
            "El Cerrito", "El Dovio", "Florida", "Ginebra", "Guacarí",
            "Jamundí", "La Cumbre", "La Unión", "La Victoria", "Obando",
            "Palmira", "Pradera", "Restrepo", "Riofrío", "Roldanillo",
            "San Pedro", "Sevilla", "Toro", "Trujillo", "Tuluá",
            "Ulloa", "Versalles", "Vijes", "Yotoco", "Yumbo", "Zarzal"
        });
        ComboDepartamentos.put("VAUPÉS", new String[] {
            "Caruru", "Mitú", "Pacoa", "Taraira", "Yavaraté"
        });
        ComboDepartamentos.put("VICHADA", new String[] {
            "Cumaribo", "La Primavera", "Puerto Carreño", "Santa Rosalía", "San José de Ocune"
        });
    }
    public void llenarItems(){
        txtNombre.setText("");
        txtApellido.setText("");
        txtCorreo.setText("");
        txtContraseña.setText("");
        txtVerificaContraseña.setText("");
        
        ImageIcon logo = new ImageIcon("src/IMG/Logo.png");
        Image img = logo.getImage().getScaledInstance(lbLogo.getWidth(), lbLogo.getHeight(), Image.SCALE_SMOOTH);
        lbLogo.setIcon(new ImageIcon(img));
        
        
        cbMes.removeAllItems();
        cbAño.removeAllItems();
        cbGenero.removeAllItems();
        cbDepartamento.removeAllItems();
        
        
        
        cbMes.addItem("Mes");
        cbAño.addItem("Año");
        cbGenero.addItem("Seleccione...");
        cbDepartamento.addItem("Seleccione...");
        
        for (int i = 0; i < ComboMeses.length; i++) {
            String item = ComboMeses[i];
            cbMes.addItem(item);
        }
        for (int i = 2025; i >= 1985; i--) {
            cbAño.addItem(Integer.toString(i));
        }
        for (int i = 0; i < ComboGenero.length; i++) {
            String item = ComboGenero[i];
            cbGenero.addItem(item);
        }
        
        
        
        
        for (String departamento : ComboDepartamentos.keySet()) {
            cbDepartamento.addItem(departamento);
        }

    // Selecciona el primer departamento por defecto
        if (cbDepartamento.getItemCount() > 0) {
            cbDepartamento.setSelectedIndex(0);
            actualizarCiudades((String) cbDepartamento.getSelectedItem());
        }
        
    }
    private void actualizarDias(){
        String seleccionado = (String) cbMes.getSelectedItem();
        cbDia.removeAllItems();
        cbDia.addItem("Dia");
        if (seleccionado == "Febrero") {
            for (int i = 1; i <= 28; i++) {
                cbDia.addItem(Integer.toString(i));
            }
        }
        else if (seleccionado != "Mes" && seleccionado != "Febrero"){
            for (int i = 1; i <= 31; i++) {
                cbDia.addItem(Integer.toString(i));
            }
        }
    }
    private void actualizarCiudades(String departamento) {
        cbCiudad.removeAllItems();
        cbCiudad.addItem("Seleccione...");
        String[] ciudades = ComboDepartamentos.get(departamento);
        if (ciudades != null) {
            for (String ciudad : ciudades) {
                cbCiudad.addItem(ciudad);
            }
        }
    }
    public void Registrarse(){
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String genero = (String) cbGenero.getSelectedItem();
        String correo = txtCorreo.getText();
        String contraseña = String.valueOf(txtContraseña.getPassword());
        String fechaDeNacimiento = "";
        String departamento = (String) cbDepartamento.getSelectedItem();
        String ciudad = (String) cbCiudad.getSelectedItem();
        String rol = "usuario";
        try {
            if (nombre.isEmpty() || apellido.isEmpty() || cbGenero.getSelectedIndex()== 0 || correo.isEmpty() || contraseña.isEmpty() || 
                    cbDia.getSelectedIndex()== 0 || cbMes.getSelectedIndex()== 0 || cbAño.getSelectedIndex()== 0 || cbDepartamento.getSelectedIndex()== 0 || cbCiudad.getSelectedIndex()== 0){
                JOptionPane.showMessageDialog(null, "Faltan campos por completar");
                
                System.out.println("Todos los parametros deben estar llenos");
            }
            else{
                try {
                        String Dia = String.format("%02d", Integer.parseInt((String)cbDia.getSelectedItem()));
                        String Mes =  String.format("%02d", cbMes.getSelectedIndex());
                        String Año = (String) cbAño.getSelectedItem();          
                        fechaDeNacimiento = String.format("%s/%s/%s", Año, Mes, Dia);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Fecha Mal Puseta");
                }
                Usuario usuario = new Usuario(nombre, apellido, genero, correo, contraseña, fechaDeNacimiento, departamento, ciudad, rol);
                System.out.println("Enviado correctamente a Usuario");
                usuario.Registrar();
            }
            
        } catch (Exception e) {
            System.out.println("Error al enviar a Usuario");
        }
        
        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
        Calendar fechaNacimiento = Calendar.getInstance();

        
        
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lbLogo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbGenero = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        txtVerificaContraseña = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        cbDia = new javax.swing.JComboBox<>();
        cbMes = new javax.swing.JComboBox<>();
        cbAño = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cbDepartamento = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cbCiudad = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        lbIniciarSesion = new javax.swing.JLabel();
        btnRegistrarse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Registrarse");

        lbLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLogo.setText("jLabel1");

        jLabel2.setText("Nombre");

        txtNombre.setText("Nombre");
        txtNombre.setToolTipText("Ingrese su Nombre");

        jLabel3.setText("Apellido");

        txtApellido.setText("Apellido");
        txtApellido.setToolTipText("Ingrese su Apellido");

        jLabel4.setText("Genero");

        cbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Correo Electronico");

        txtCorreo.setText("Example@gmail.com");
        txtCorreo.setToolTipText("Example@gmail.com");

        jLabel6.setText("Contraseña");

        txtContraseña.setText("jPasswordField1");
        txtContraseña.setToolTipText("Ingrese su contraseña");

        jLabel7.setText("Verifique su contraseña");

        txtVerificaContraseña.setText("jPasswordField2");
        txtVerificaContraseña.setToolTipText("Verifique su contraseña");

        jLabel8.setText("Fecha de nacimiento");

        cbDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMesActionPerformed(evt);
            }
        });

        cbAño.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("Departamento");

        cbDepartamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDepartamentoActionPerformed(evt);
            }
        });

        jLabel10.setText("Ciudad");

        cbCiudad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setText("Si ya tienes cuenta puedes");

        lbIniciarSesion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbIniciarSesion.setText("Iniciar Sesion");
        lbIniciarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbIniciarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbIniciarSesionMouseClicked(evt);
            }
        });

        btnRegistrarse.setText("Registrarse");
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lbLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(lbIniciarSesion)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(26, 26, 26))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(cbGenero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtVerificaContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(cbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(cbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(btnRegistrarse, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(cbDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(cbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(cbAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(7, 7, 7)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtVerificaContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbIniciarSesion)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        new FrmPantallaPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosed

    private void lbIniciarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbIniciarSesionMouseClicked
        // TODO add your handling code here:
        FrmLogin nuevoForm = new FrmLogin();
        nuevoForm.setVisible(true);
        nuevoForm.setLocationRelativeTo(null);
        this.setVisible(false);
    }//GEN-LAST:event_lbIniciarSesionMouseClicked

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
        // TODO add your handling code here:
        Registrarse();
        
    }//GEN-LAST:event_btnRegistrarseActionPerformed

    private void cbDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDepartamentoActionPerformed
        // TODO add your handling code here:
        String seleccionado = (String) cbDepartamento.getSelectedItem();
        actualizarCiudades(seleccionado);
    }//GEN-LAST:event_cbDepartamentoActionPerformed

    private void cbMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMesActionPerformed
        // TODO add your handling code here:
        actualizarDias();
    }//GEN-LAST:event_cbMesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmRegistrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRegistrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRegistrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRegistrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRegistrarse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JComboBox<String> cbAño;
    private javax.swing.JComboBox<String> cbCiudad;
    private javax.swing.JComboBox<String> cbDepartamento;
    private javax.swing.JComboBox<String> cbDia;
    private javax.swing.JComboBox<String> cbGenero;
    private javax.swing.JComboBox<String> cbMes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbIniciarSesion;
    private javax.swing.JLabel lbLogo;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtVerificaContraseña;
    // End of variables declaration//GEN-END:variables
}
