'use client'


//Enzo Ferroni - RA: 10417100
//Leonardo Rodrigues - RA: 10418105
//Rafael Neves - RA: 10418316
import Image from "next/image";
import "./style.css";
import Cartao from "../Componentes/Cartao";
import { useEffect, useState } from "react";
import Link from "next/link";
import Menu from "../Componentes/Menu";
export default function Home() {
  const [cartoes, setCartoes] = useState([]);
  
  const getCartoes = () => {
    fetch(
      "http://127.0.0.1:8080/api/cartao",
    )
      .then((r) => r.json())
      .then((f) => {
        console.log(f);
        setCartoes(f)
      });
  }

  const adicionarCartoes = async () => { 
    
    fetch("http://127.0.0.1:3000/api/cartao", {
       method: "POST",
       headers: {
        'Content-type': 'application/json',
       },
       body: JSON.stringify({"numCartao": (Math.random(100) * 100), "senha": 123, "dataValidade" : "12/31", "numConta": 1}),
      })
      .then((resp) => resp.json())
      .then((d) => {
        console.log(d);
        getCartoes();
      })
}

  useEffect(getCartoes, []);
  
  
  
  return (
    <>
    <Menu></Menu>
    <h1>Meus Cartões</h1>
    <section class="cartoes">
    {cartoes.map(cart => (
          <Cartao num={cart.numCartao} senha={cart.pin} validade={cart.dataValidade}/>
        ))}
      
    </section>
    <button class="novo-cartao" onClick={adicionarCartoes}>Adicionar Cartão</button>

</>
  );
}
