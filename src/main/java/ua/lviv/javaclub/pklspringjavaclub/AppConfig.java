package ua.lviv.javaclub.pklspringjavaclub;

import java.util.List;
import java.util.Objects;

import org.pkl.config.java.mapper.Named;
import org.pkl.config.java.mapper.NonNull;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public final class AppConfig {
    public final @NonNull Server server;

    public AppConfig(@Named("server") @NonNull Server server) {
        this.server = server;
    }

    public AppConfig withServer(@NonNull Server server) {
        return new AppConfig(server);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        AppConfig other = (AppConfig) obj;
        if (!Objects.equals(this.server, other.server)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Objects.hashCode(this.server);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(100);
        builder.append(AppConfig.class.getSimpleName()).append(" {");
        appendProperty(builder, "server", this.server);
        builder.append("\n}");
        return builder.toString();
    }

    private static void appendProperty(StringBuilder builder, String name, Object value) {
        builder.append("\n  ").append(name).append(" = ");
        String[] lines = Objects.toString(value).split("\n");
        builder.append(lines[0]);
        for (int i = 1; i < lines.length; i++) {
            builder.append("\n  ").append(lines[i]);
        }
    }

    @ConfigurationProperties("server")
    public static final class Server {
        public final @NonNull List<@NonNull Endpoint> endpoints;

        public Server(@Named("endpoints") @NonNull List<@NonNull Endpoint> endpoints) {
            this.endpoints = endpoints;
        }

        public Server withEndpoints(@NonNull List<@NonNull Endpoint> endpoints) {
            return new Server(endpoints);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (this.getClass() != obj.getClass()) return false;
            Server other = (Server) obj;
            if (!Objects.equals(this.endpoints, other.endpoints)) return false;
            return true;
        }

        @Override
        public int hashCode() {
            int result = 1;
            result = 31 * result + Objects.hashCode(this.endpoints);
            return result;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder(100);
            builder.append(Server.class.getSimpleName()).append(" {");
            appendProperty(builder, "endpoints", this.endpoints);
            builder.append("\n}");
            return builder.toString();
        }
    }

    public static final class Endpoint {
        public final @NonNull String name;

        public final int port;

        public Endpoint(@Named("name") @NonNull String name, @Named("port") int port) {
            this.name = name;
            this.port = port;
        }

        public Endpoint withName(@NonNull String name) {
            return new Endpoint(name, port);
        }

        public Endpoint withPort(int port) {
            return new Endpoint(name, port);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (this.getClass() != obj.getClass()) return false;
            Endpoint other = (Endpoint) obj;
            if (!Objects.equals(this.name, other.name)) return false;
            if (!Objects.equals(this.port, other.port)) return false;
            return true;
        }

        @Override
        public int hashCode() {
            int result = 1;
            result = 31 * result + Objects.hashCode(this.name);
            result = 31 * result + Objects.hashCode(this.port);
            return result;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder(150);
            builder.append(Endpoint.class.getSimpleName()).append(" {");
            appendProperty(builder, "name", this.name);
            appendProperty(builder, "port", this.port);
            builder.append("\n}");
            return builder.toString();
        }
    }
}
