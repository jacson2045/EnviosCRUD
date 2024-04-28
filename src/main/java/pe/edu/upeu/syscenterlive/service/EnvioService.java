package pe.edu.upeu.syscenterlive.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import pe.edu.upeu.syscenterlive.modelo.Envio;

@Service
public class EnvioService {

    List<Envio> listaEnvios = new ArrayList<>();

    public boolean agregarEnvio(Envio envio) {
        return this.listaEnvios.add(envio);
    }

    public List<Envio> listarEnvio() {
        return listaEnvios;
    }

    public Envio buscarEnvio(String codigo) {
        for (Envio envio : listaEnvios) {
            if (envio.getCodigo().equalsIgnoreCase(codigo)) {
                return envio;
            }
        }
        return null;
    }

    public Envio actualizarEnvio(Envio envioActualizado) {
        for (Envio envio: listaEnvios) {
            if (envio.getCodigo().equalsIgnoreCase(envioActualizado.getCodigo())) {
                envio.setCodigo(envioActualizado.getCodigo());
                envio.setLlegada(envioActualizado.getLlegada());
                envio.setPartida(envioActualizado.getPartida());
                envio.setProducto(envioActualizado.getProducto());
                return envio;
            }
        }
        return null;
    }

    public void eliminarEnvio(String codigo) {
        listaEnvios.removeIf(envio -> envio.getCodigo().equalsIgnoreCase(codigo));
    }
}
