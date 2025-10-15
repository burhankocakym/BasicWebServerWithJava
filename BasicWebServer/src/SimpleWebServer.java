import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SimpleWebServer {

    public static void main(String[] args) {
        final int PORT = 1989;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Sunucu " + PORT + " portunda başlatıldı.");
            System.out.println("Tarayıcınızdan http://localhost:" + PORT + " adresine giderek test edebilirsiniz.");

            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    System.out.println("Yeni bir istemci bağlandı: " + clientSocket.getInetAddress().getHostAddress());
                    String htmlContent = buildHtmlResponse();
                    sendResponse(clientSocket, htmlContent);
                } catch (IOException e) {
                    System.err.println("İstemci bağlantısı kabul edilirken hata oluştu: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Sunucu " + PORT + " portunda başlatılamadı: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static String buildHtmlResponse() {
        return String.join("\n",
                "<!DOCTYPE html>",
                "<html lang=\"tr\">",
                "<head>",
                "    <meta charset=\"UTF-8\">",
                "    <title>Java Web Sunucusu</title>",
                "    <style>",
                "        body {",
                "            background-color: #f0f2f5;",
                "            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;",
                "            display: flex;",
                "            justify-content: center;",
                "            align-items: center;",
                "            min-height: 100vh;",
                "            margin: 0;",
                "        }",
                "        .container {",
                "            background-color: #ffffff;",
                "            padding: 40px;",
                "            border-radius: 10px;",
                "            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);",
                "            max-width: 700px;",
                "            text-align: center;",
                "        }",
                "        h1 { color: #0d47a1; margin-bottom: 5px; }",
                "        h2 { color: #555; margin-top: 0; font-weight: 400; }",
                "        hr { border: 0; border-top: 1px solid #eee; margin: 25px 0; }",
                "        p { color: #333; font-size: 17px; line-height: 1.7; text-align: justify; }",
                "        p strong { font-weight: bold; }",
                "        p u { text-decoration: underline; }",
                "    </style>",
                "</head>",
                "<body>",
                "    <div class=\"container\">",
                "        <h1>Burhan KOÇAK</h1>",
                "        <h2>1230505064</h2>",
                "        <hr>",
                "        <p>",
                "            Ben <strong>Burhan Koçak</strong>, <u>Yazılım Mühendisliği</u> bölümü 3. sınıf öğrencisi olarak, eğitimimi <strong style='color:#0277bd;'>Makine Öğrenmesi</strong> ve <strong style='color:#00695c;'>Veri Bilimi</strong> gibi çağımızın en dinamik alanlarında derinleştirmeye odakladım.",
                "            Şu anki temel önceliğim, bu disiplinlerde <em style='color:#424242;'>ileride hayata geçirmeyi hedeflediğim yenilikçi projeler için sağlam bir teorik ve pratik altyapı kurma</em> sürecidir.",
                "        </p>",
                "    </div>",
                "</body>",
                "</html>"
        );
    }

    private static void sendResponse(Socket clientSocket, String htmlBody) throws IOException {
        OutputStream output = clientSocket.getOutputStream();
        PrintWriter writer = new PrintWriter(output, true, StandardCharsets.UTF_8);

        writer.println("HTTP/1.1 200 OK");
        writer.println("Content-Type: text/html; charset=UTF-8");
        writer.println("Content-Length: " + htmlBody.getBytes(StandardCharsets.UTF_8).length);
        writer.println();
        writer.print(htmlBody);
        writer.flush();
    }
}