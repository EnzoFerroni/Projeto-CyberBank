'use client'
import { useEffect, useState } from "react";
import Transacao from "../Componentes/Transacao";
import Menu from "../Componentes/Menu";
import "./stle.css";


export default function Home(){
    const [tr, setTr] = useState([]);
    const getTr = () => {
      fetch(
        "http://127.0.0.1:8080/api/transacao?contaAtual=" + document.cookie.split("sessao=")[1],
      )
        .then((r) => r.json())
        .then((f) => {
          console.log(f);
          setTr(f)
        });
    }

    const adicionarTr= async () => { 
    
        fetch("http://127.0.0.1:3000/api/transacao", {
           method: "POST",
           headers: {
            'Content-type': 'application/json',
           },
           body: JSON.stringify({"codTransacao" : Math.random(100) * 100, "conta": 3, "contaAtual": 1, "dataHora": "Wed-29", "valor": 1}),
          })
          .then((resp) => resp.json())
          .then((d) => {
            console.log(d);
            getTr();
          })
    }

    useEffect(getTr, []);
    return(

        <>
        <Menu></Menu>
        <h1>Lista de Transações</h1>

    <table class="tabela-transacoes">
        <thead>
            <tr>
                <th>Código</th>
                <th>Data</th>
                <th>Valor</th>
                <th>Origem</th>
                <th>Destino</th>
            </tr>
        </thead>
        <tbody>
        {tr.map(t => (
          <Transacao id={t.codTransacao} data={t.dataHora} valor={t.valor} origem={t.contaAtual} destino={t.conta} />
        ))}
        </tbody>
        
    </table>
    <button class="nova-transacao" onClick={adicionarTr}>Nova Transação</button>
    </>
    );
}