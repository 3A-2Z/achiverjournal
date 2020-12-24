import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import Entry from './Entry'
import reportWebVitals from './reportWebVitals';
import { Switch,Route,Link, HashRouter as Router } from 'react-router-dom';

ReactDOM.render(
  <React.StrictMode>
    <Router>
    <Route path="/journal" component = {App} />
    <Route path="/entry" component = {Entry} />
    </Router>
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
