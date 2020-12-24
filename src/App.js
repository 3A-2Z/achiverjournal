import logo from './github-brands.svg';
import './App.scss';
import { useEffect, useState } from 'react';
import {Link} from 'react-router-dom';
/*
* Functions as a view for the AchieverJournal component
*/
function App() {
  const [entries,setEntries] = useState([])
  /*
  * Retrieves all journal entries from the AchieverJournal API
  */
  useEffect(
    () => {fetch('http://achieverjournal-env.eba-2ezdz2u2.us-east-1.elasticbeanstalk.com//api/v1/entries').
      then(res => res.json()).
      then(entries => {setEntries(entries)})
  },[]


  )
  

  
  return (
    <div className="App">
      <header className="App-header">
        <a href="https://github.com/3A-2Z"><img src={logo} class="fa-github"></img></a>
      
          <div class="container">
  <Link to="/entry"><button class="new-entry">Begin Writing Towards Your Goals!</button></Link>
  <h2>Your Journal Entries!</h2>
  <ul class="responsive-table">
    <li class="table-header">
      <div class="col col-1">Entry Title</div>
      <div class="col col-2">Date</div>
      <div class="col col-3">Entry Link</div>
     
    </li>
    {entries.map(entry =>
    <li class="table-row">
      <div class="col col-1" >{entry.title}</div>
      <div class="col col-2" >{entry.date}</div>
      <div class="col col-3" ><Link to={`/entry/${entry.ID}`}>Go to Entry!</Link></div>{/* links to journal entry based on ID which is sent to the Journal Entry component*/}
      
    </li>
    )}
    </ul>
    </div>
       
      </header>
    </div>
  );
}

export default App;
