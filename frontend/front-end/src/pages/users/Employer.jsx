import React, {useEffect, useState} from 'react'
import { Table } from 'semantic-ui-react'
import EmployerService from "../../services/employerService"

export default function Employer() {
    const [employers, setEmployers] = useState([])

    useEffect(() => {
        let employerService = new EmployerService();
        employerService.getEmployer().then(sonuc => setEmployers(sonuc.data.data));},[])
     return (
         <div>
          
              <Table style = {{margin: "5em"}}>
     <Table.Header>
       <Table.Row>
         <Table.HeaderCell>Şirket Adı</Table.HeaderCell>
         <Table.HeaderCell>Mail</Table.HeaderCell>
         <Table.HeaderCell>Web Site</Table.HeaderCell>
       </Table.Row>
     </Table.Header>
    
     
     <Table.Body>
         {
         employers.map(employer => (
       <Table.Row key = {employer.id}>
         <Table.Cell>{employer.companyName}</Table.Cell>
         <Table.Cell>{employer.mail}</Table.Cell>
         <Table.Cell>{employer.webAddress}</Table.Cell>
       </Table.Row>
         ))}
      </Table.Body>
     
   </Table>
         </div>

         
     )
}
