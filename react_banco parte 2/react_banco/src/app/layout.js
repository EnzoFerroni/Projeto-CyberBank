import { Inter } from "next/font/google";
import "./globals.css";
//Enzo Ferroni - RA: 10417100
//Leonardo Rodrigues - RA: 10418105
//Rafael Neves - RA: 10418316

const inter = Inter({ subsets: ["latin"] });

export const metadata = {
  title: "Create Next App",
  description: "Generated by create next app",
};

export default function RootLayout({ children }) {
  return (
    <html lang="en">
      <head>
        
      </head>
      <body className={inter.className}>{children}
      <footer>
        <section class="autoria">
            <div class="copyright_titulo">
                <img id="copyright" src="Copyright.png" alt="Símbolo de Copyright"></img>
                <p>CyberBank</p>
            </div>
            <p class="autor">Enzo Ferroni - RA: 10417100</p>
            <p class="autor">Leonardo Rodrigues - RA: 10418105</p>
            <p class="autor">Rafael Neves de Oliveira - RA: 10418316</p>
            <p class="complementar">2024</p>
        </section>
    </footer>
      </body>
    </html>
  );
}
