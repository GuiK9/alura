package org.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServidorTarefas {
    private final ServerSocket servidor;
    private final ExecutorService threadPool;
    private boolean estaRodando;

    public ServidorTarefas() throws IOException {
        System.out.println("----- iniciando o servidor -----");
        this.servidor = new ServerSocket(12345);
        this.threadPool = Executors.newCachedThreadPool();
        this.estaRodando = true;
    }
    public static void main(String[] args) throws Exception {
        ServidorTarefas servidor = new ServidorTarefas();
        servidor.rodar();
        servidor.parar();
    }
    public void rodar() throws IOException {
        while(this.estaRodando){
            Socket socket = servidor.accept();
            DistribuirTarefas distribuirTarefas = new DistribuirTarefas(socket, this);
            threadPool.execute(distribuirTarefas);
        }
    }
    public void parar() throws IOException {
        estaRodando = false;
        servidor.close();
        threadPool.shutdown();
    }
}