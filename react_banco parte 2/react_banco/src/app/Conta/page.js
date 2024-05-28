'use client'
import { useEffect, useState } from "react";
import "./style.css";
import Menu from "../Componentes/Menu";

//Enzo Ferroni - RA: 10417100
//Leonardo Rodrigues - RA: 10418105
//Rafael Neves - RA: 10418316

export default function Home(){
    const [contas, setConta] = useState([]);
    const getConta = () => {
        fetch(
            "http://127.0.0.1:8080/api/conta/" + document.cookie.split("sessao=")[1])
            .then((r) => r.json())
            .then((f) => {
              console.log(f);
              setConta([f.cliente.nome, f.numConta, f.agencia, f.saldo])
            });
    }

    useEffect(getConta, []);
    

    return(
        <>
        <Menu></Menu>
        <div class="card"> 
            <h1>Detalhes da Conta</h1>




                <div className="info">
                <p><strong>Nome:</strong>{contas[0]}</p>
                <p><strong>Número da Conta:</strong> {contas[1]}</p>
                <p><strong>Agência:</strong> {contas[2]}</p>
                <p><strong>Saldo:</strong> {contas[3]}</p>
                </div>

        </div>
        </>
    );
}