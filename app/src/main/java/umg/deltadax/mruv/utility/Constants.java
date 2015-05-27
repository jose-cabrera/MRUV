package com.centrikal.visitasmovil.utility;

import com.centrikal.visitasmovil.database.objects.DbActividadesObject;
import com.centrikal.visitasmovil.database.objects.DbAgendaObject;
import com.centrikal.visitasmovil.database.objects.DbVisitasObject;

import android.location.Location;
import android.os.Environment;

public class Constants {
    public static class SHAREDPREFS {
        // Usuario
        public static String USUARIO_ACTIVO;
        public static int TIPO_USUARIO;

        public static int LOTES_ACTIVO;
        public static int CRONOMETRO_VISIBLE;
        public static boolean SINCRO_MANUAL = false;
        public static boolean LOGIN_SERVICE_ACTIVO = false;
        public static String PICTURE_PATH = Environment.getExternalStorageDirectory().getPath()
                + "/Android/data/com.centrikal.visitasmovil/";

        // Info necesaria para el flujo
        public static DbAgendaObject AGENDA_ACTIVA;
        public static DbVisitasObject VISITA_ACTIVA;
        public static DbActividadesObject ACTIVIDAD_ACTIVA;
        public static int ACTIVIDAD_DINAMICA = 0;

        // Coordenadas
        public static Location networkLocation;
        public static Location gpsLocation;
        public static Location pasiveLocation;

        public static Location networkLocationLastFix;
        public static Location gpsLocationLastFix;
        public static Location pasiveLocationLastFix;

        public static Location googlePlayLastFix;

        // LOG
        public static int LOG_ACTIVO;
        public static int LOG_TIPO;

        // Cronometro
        public static int CRONOMETRO_ACTIVO;

        // ENVIO CLIENTE NUEVO
        public static boolean DESDE_DESCARGAS;

        public static int salvarPosicionFragment = 0;
    }

    public static class CONSTANTS {

        // ESTADO USUARIO
        public static final int ESTADO_ACTIVO = 1;
        public static final int ESTADO_NO_ACTIVO = -1;

        // SHAREPREFS
        public static final String KEY_USUARIO = "com.centrikal.visitas.usuario";
        public static final String KEY_TIPO_USUARIO = "com.centrikal.visitas.usuario_tipo";
        public static final String KEY_AGENDA = "com.centrikal.visitas.agenda";
        public static final String KEY_VISITA = "com.centrikal.visitas.visita";
        public static final String KEY_ACTIVIDAD = "com.centrikal.visitas.actividad";
        public static final String KEY_ACTIVIDAD_DINAMICA = "com.centrikal.visitas.actividad_dinamica";
        public static final String KEY_CRONOMETRO_VISIBLE = "com.centrikal.visitas.cronometro_visible";
        public static final String KEY_CRONOMETRO_ACTIVO = "com.centrikal.visitas.cronometro_activo";
        public static final String KEY_SALVAR_FRAGMENT = "com.centrikal.visitas.salvar_fragment";
        public static final String KEY_SALVAR_MEMO_DETALLE = "com.centrikal.visitas.salvar_memo_detalle";

        // POSICIONES SALVAR FRAGMEN
        public static final int SALVAR_FRAGMENT_AGENDA = 1;
        public static final int SALVAR_FRAGMENT_VISITA = 2;
        public static final int SALVAR_FRAGMENT_VISITA_GRUPAL = 3;
        public static final int SALVAR_FRAGMENT_ACTIVIDADES = 4;
        public static final int SALVAR_FRAGMENT_NINGUNA = 99999999;
        public static final int SALVAR_FRAGMENT_BUSQUEDA = 5;
        public static final int SALVAR_FRAGMENT_MEMO_DETALLE = 328417;

        // VISITA GRUPAL
        public static final int SIN_GRUPO = -1;
        public static final int ES_PADRE = 1;
        public static final int NO_ES_PADRE = -1;

        // ERROR WS
        public static final String WS_ERROR = "ERROR" + GetFechaHora.getFechaDMY();

        // PATH
        public static final String PICTURE_PATH = Environment.getExternalStorageDirectory().getPath()
                + "/Android/data/com.centrikal.visitasmovil/";
        public static final String ROOT_PATH = Environment.getExternalStorageDirectory().getPath();

        // MEMOS
        public static final int TIENE_MEMOS = 1;
        public static final int SIN_RESPUESTA = 1000;

        // TIPOS LOG
        public static final int LOG_ONLY_ERRORS = 1;
        public static final int LOG_ONLY_DB = 2;
        public static final int LOG_ONLY_WS = 3;
        public static final int LOG_ALL = 4;
        public static final int LOG_FILES_AND_CAT = 0;
        public static final int LOG_CAT = 1;
        public static final int LOG_FILES = 2;

        // Estados
        public static final int PENDIENTE = 0;
        public static final int REALIZADA = 1;
        public static final int EJECUCION = 2;
        public static final int CANCELADA = 3;

        // Estados cambio fecha
        public static final int SUFRIO_CAMBIO_FECHA = 1;
        public static final int NO_SUFRIO_CAMBIO_FECHA = -1;

        // Visitas
        public static final int TABPENDIENTE_VISITA = 0;
        public static final int TABFINALIZADOS_VISITA = 1;
        public static final int TABALL_VISITA = 2;

        // Agenda
        public static final int TABPENDIENTES_AGENDA = 0;
        public static final int TABREALIZADAS_AGENDA = 1;
        public static final int TABALL_AGENDA = 2;

        // Estados sincronizacion
        public static final int NO_SINCRONIZADA = -1;
        public static final int SINCRONIZADA = 1;
        public static final int SINCRONIZANDO = 2;

        // Varios
        public static final int SIN_ID = 0;
        public static final int DESCARTABLE = 1;// No Obligatorio
        public static final int ACTIVIDAD_NO_DESCARTABLE = -1;// No Obligatorio
        public static final int NO_DESCARTABLE = 0;// Obligatorio

        // Tipos Visita
        public static final int TIPO_TODAS = 0;

        // Tipos Inventario
        public static final int INV_TIPO_MEDICINA = 1;
        public static final int INV_TIPO_PUBLICIDAD = 2;

        // Inventario Sugerido
        public static final int INV_AGREGADO = 1;
        public static final int INV_NO_AGREGADO = -1;

        // Tipo Usuario
        public static final int TIPO_USUARIO_SUPERVISOR = 1;
        public static final int TIPO_USUARIO_VENDEDOR = 2;

        // ID Ingreso Cronometro
        public static final int ID_CRONOMETRO_SALA_ESPERA = 847481;
        public static final int ID_CRONOMETRO_VISITA = 847482;
        public static final int ID_HORA_INICIO_SALA_ESPERA = 847483;
        public static final int ID_HORA_INICIO_VISITA = 847484;
        public static final int ID_HORA_FIN_VISITA = 847485;

        // Cronometro
        public static final int CRONOMETRO_SALA = 1;
        public static final int CRONOMETRO_VISITA = 2;
        public static final int CRONOMETRO_ESTADO_PAUSADO = 1;
        public static final int CRONOMETRO_ESTADO_CORRIENDO = 2;
        public static final int CRONOMETRO_ESTADO_DETENIDO = 3;
        public static final int CRONOMETRO_VISIBLE = 1;
        public static final int CRONOMETRO_NO_VISIBLE = -1;

        // FECHA DEFAULT PARA FECHA DINAMICA
        public static final String FECHA_DEFAULT_DIA = "DEFAULT_DIA";
        public static final String FECHA_DEFAULT_MES = "DEFAULT_MES";
        public static final String FECHA_DEFAULT_ANIO = "DEFAULT_ANIO";

        // Agregar cliente ID_activida
        public static final int ACTIVIDAD_AGREGAR_CLIENTE = 31280089;

        // ID ACTIVIDAD LISTA DE DOCTORES VISITA GRUPAL
        public static final int ID_ASISTENCIA_MEDICOS = 31280100;

        // CEL NO DISPONIBLE
        public static final String TEL_NO_DISPONIBLE = "No disponible";

        // TABS RESUMEN
        public static final int TAB_RESUMEN_HOY = 0;
        public static final int TAB_RESUMEN_MES = 1;
        public static final int TAB_RESUMEN_TODO = 2;
    }

    public static class INGRESOS {

        // Tipos de ingreso
        public static final int TIPO_TEXTO = 1;
        public static final int TIPO_INGRESO_TEXTO = 2;
        public static final int TIPO_INGRESO_NUMERO = 3;
        public static final int TIPO_INGRESO_DECIMAL = 4;
        public static final int TIPO_INGRESO_CORREO = 5;
        public static final int TIPO_INGRESO_FECHA = 6;
        public static final int TIPO_INGRESO_HORA = 7;
        public static final int TIPO_SELECT = 8;
        public static final int TIPO_FOTOGRAFIA = 9;
        public static final int TIPO_CODIGO_BARRAS = 10;
        public static final int TIPO_INVENTARIO = 11;
        public static final int TIPO_INICIO = 12;
        public static final int TIPO_FIN = 13;
        public static final int TIPO_RADIO_BUTTON = 14;
        public static final int TIPO_CHECK_BUTTON = 15;
        public static final int TIPO_INGRESO_TEXT_AREA = 16;
        public static final int TIPO_TITULO = 17;
        public static final int TIPO_CAMBIO_DE_FECHA = 18;
        public static final int TIPO_CRONOMETRO = 19;
        public static final int TIPO_INVENTARIO_PUBLICIDAD = 20;
        public static final int TIPO_TELEFONO = 21;
        public static final int TIPO_FOTOGRAFIA_BAJA = 22;
        public static final int TIPO_FOTOGRAFIA_MEDIA = 23;
        public static final int TIPO_FOTOGRAFIA_ALTA = 24;
        public static final int TIPO_FOTOGRAFIA_MAXIMA = 25;
        public static final int TIPO_DPI_CUI = 26;
        public static final int TIPO_DPI_PRIMER_NOMBRE = 27;
        public static final int TIPO_DPI_SEGUNDO_NOMBRE = 28;
        public static final int TIPO_DPI_TERCER_NOMBRE = 29;
        public static final int TIPO_DPI_PRIMER_APELLIDO = 30;
        public static final int TIPO_DPI_SEGUNDO_APELLIDO = 31;
        public static final int TIPO_DPI_SEXO = 32;
        public static final int TIPO_DPI_MUNICIPIO_NACIMIENTO = 33;
        public static final int TIPO_DPI_DEPARTAMENTO_NACIMIENTO = 34;
        public static final int TIPO_DPI_PAIS_NACIMIENTO = 35;
        public static final int TIPO_DPI_FECHA_NACIMIENTO = 36;
        public static final int TIPO_DPI_FECHA_EMISION = 37;
        public static final int TIPO_DPI_FECHA_VENCIMIENTO = 38;
        public static final int TIPO_DPI_ESTADO_CIVIL = 39;
        public static final int TIPO_DPI_MUNICIPIO_VECINDAD = 40;
        public static final int TIPO_DPI_DEPARTAMENTO_VECINDAD = 41;
        public static final int TIPO_DPI_SABE_LEER = 42;
        public static final int TIPO_DPI_SABE_ESCRIBIR = 43;
        public static final int TIPO_DPI_LIMITACION_FISICA = 44;
        public static final int TIPO_DPI_LIBRO = 45;
        public static final int TIPO_DPI_FOLIO = 46;
        public static final int TIPO_DPI_PARTIDA = 47;
        public static final int TIPO_DPI_DIRECCION = 48;
        public static final int TIPO_DPI_NO_CASA = 49;
        public static final int TIPO_DPI_MUNICIPIO_EXTENDIDO = 50;
        public static final int TIPO_DPI_DEPARTAMENTO_EXTENDIDO = 51;
        public static final int TIPO_DPI_NACIONALIDAD = 52;
        public static final int TIPO_DPI_PROFESION = 53;
        public static final int TIPO_DPI_CEDULA = 54;
        public static final int TIPO_DPI_MUNICIOPIO_CEDULA = 55;
        public static final int TIPO_DPI_FOTOGRAFIA = 56;
        public static final int NUMERO_TIPO_INGRESOS = 57;

    }

    public static class MENU_DINAMICO {

        // Codigo de las Acciones
        public static final int CODIGO_AGENDA = 1;
        public static final int CODIGO_VISITAS = 2;
        public static final int CODIGO_MEMOS = 3;
        public static final int CODIGO_PLANIFICACION_MUESTRAS = 4;
        public static final int CODIGO_INVENTARIO = 5;
        public static final int CODIGO_TIEMPO_FUERA = 6;
        public static final int CODIGO_AGREGAR_CLIENTE = 7;
        public static final int CODIGO_OPCIONES = 8;
        public static final int CODIGO_VER_GRUPO = 9;
        public static final int CODIGO_CERRAR_SESION = 10;
        public static final int CODIGO_RESUMEN = 11;
        public static final int CODIGO_VISITAS_SIN_AGENDA = 12;

    }

    public static class DB {
        public static final String DBNAMED = "VM_DataBase";
        public static final int DBVER = 6;
    }

    public static class WEBSERVICES {
        public static final String URL_LOG = "http://centrikal.cloudant.com/acra-qualipharm/_design/acra-storage/_update/report";

        public static String[] URLs = {"http://216.230.141.130:8008/qualipharm/site/index.php?r=service/Solicitud",
                "http://centrikal.com/services/qualipharm/a_falta_de_miguel.php",
                "http://10.10.20.101:8008/qualipharm/site/index.php?r=service/Solicitud",
                "http://10.10.20.139:8888/qualipharm/site/index.php?r=service/Solicitud",
                "http://centrikal.com/qualipharm/qualifarm/index.php?r=service/Solicitud",
                "http://centrikal.com/agendaMedica/site/index.php?r=service/Solicitud",
                "http://10.10.20.8:8888/qualipharm/site/index.php?r=service/Solicitud"};

        public static String URLWS = URLs[0];
        public static final String WSPARAM = "tran";
        public static final int WS_CORRECTO = 1;
        public static final int WS_INCORRECTO = -1;
    }

    public static class ACRACONSTANTS {
        public static final String USER = "acra_user_active";
        public static final String URL = "acra_url_active";
    }

    public static class GAInfo {
        public static class GACategory {
            public static final String sesion = "Sesion", agenda = "Agenda", visita = "Visita",
                    actividad = "Actividad", sincro = "Sincronización", memos = "Memos",
                    tiempo_fuera = "Tiempo fuera de territorio", ver_grupo = "Ver grupo";
        }

        public static class GAAction {
            public static final String button = "Botón", eventos = "Evento";
        }

        public static class GALabel {
            public static final String login = "Login correcto", login_fallido = "Login fallido",
                    cierre_Sesion = "Cierre de sesion", obtener_datos = "Obtener datos manual",
                    obtener_datos_auto = "Obtener datos manual",
                    reintento_obtener_datos = "Reintento al obtener datos", terminar_actividad = "Terminar actividad",
                    terminar_visita = "Terminar visita", terminar_agenda = "Terminar agenda",
                    resumen_inventario = "Revisar resumen inventario", ver_memo = "ver memo",
                    memo_enviar_respuesta = "Enviar respuesta", memos_pdf = "Ver pdf", memos_url = "Ver url",
                    memos_imagen = "Ver imagen", sincro_manual = "Enviar datos",
                    tiempo_fuera = "Envio tiempo fuera de territorio", ver_grupo = "Ver datos de usuarios asignados",
                    no_internet = "Sin conexion a internet",
                    problemas_ws = "Ocurrio algun error con la comunicación con el WS";
        }

    }
}
