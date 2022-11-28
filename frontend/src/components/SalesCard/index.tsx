import axios from "axios";
import { useEffect, useState } from "react";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import { Sale } from "../../models/sale";
import { BASE_URL } from "../../utils/request";

import NotificationButton from '../NotificationButton';
import './styles.css';

function SalesCard() {

  const min = new Date(new Date().setDate(new Date().getDate() - 365));
  const max = new Date();

  /*estado declarado - dado composto declarado (dado + função que muda o dado). Atribuída a declaração começando com a data atual*/
  const [minDate, setMinDate] = useState(min);
  const [maxDate, setMaxDate] = useState(max);

  /*armazenando lista de vendas*/
  const [sales, setSales] = useState<Sale[]>([]);

  /*reack hook - executar algo quando o componente é montado a primeira vez
  e também executa esse algo quando algum dado informado, alterar. é possível controlar isso, com execução de função
  useEffect((função) => {corpo da função}, [lista de dependências])*/
  useEffect(() => {

    /*convertendo e recortando para a impressão correta da data*/ 
    const dmin = minDate.toISOString().slice(0, 10);
    const dmax = maxDate.toISOString().slice(0, 10);

    axios.get(`${BASE_URL}/sales?minDate=${dmin}&maxDate=${dmax}`)
      .then(response => {
        setSales(response.data.content);
      });
  }, [minDate, maxDate]); /*vendas voltando do backend*/


  return (
    <div className="dsmeta-card">
      <h2 className="dsmeta-sales-title">Vendas</h2>
      <div>
        <div className="dsmeta-form-control-container">
          <DatePicker
            selected={minDate}
            onChange={(date: Date) => setMinDate(date)}
            className="dsmeta-form-control"
            dateFormat="dd/MM/yyyy"
          />
        </div>
        <div className="dsmeta-form-control-container">
          <DatePicker
            selected={maxDate}
            onChange={(date: Date) => setMaxDate(date)}
            className="dsmeta-form-control"
            dateFormat="dd/MM/yyyy"
          />
        </div>
      </div>

      <div>
        <table className="dsmeta-sales-table">
          <thead>
            <tr>
              <th className="show992">ID</th>
              <th className="show576">Data</th>
              <th>Vendedor</th>
              <th className="show992">Visitas</th>
              <th className="show992">Vendas</th>
              <th>Total</th>
              <th>Notificar</th>
            </tr>
          </thead>
          <tbody>
            {sales.map(sale => {
              return (
                <tr key={sale.id}>
                  <td className="show992">{sale.id}</td>
                  <td className="show576">{new Date(sale.date).toLocaleDateString()}</td>
                  <td>{sale.sellerName}</td>
                  <td className="show992">{sale.visited}</td>
                  <td className="show992">{sale.deals}</td>
                  <td>R$ {sale.amount.toFixed(2)}</td>
                  <td>
                    <div className="dsmeta-red-btn-container">
                      <NotificationButton />
                    </div>
                  </td>
                </tr>
              )
            })}
          </tbody>

        </table>
      </div>

    </div>
  )
}

export default SalesCard;
