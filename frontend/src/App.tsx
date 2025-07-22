import React, { useState } from 'react';

interface Entry {
  name?: string;
  amount: number;
  date?: string;
  cardName?: string;
}

const api = 'http://localhost:8080/api';

function App() {
  const [income, setIncome] = useState<Entry>({amount:0});
  const [liability, setLiability] = useState<Entry>({amount:0});
  const [card, setCard] = useState<Entry>({amount:0});
  const [saving, setSaving] = useState<number>(0);
  const [summary, setSummary] = useState<any>(null);

  const post = (path: string, body: any) => fetch(`${api}${path}`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(body)
  });

  return (
    <div>
      <h1>Budget App</h1>
      <div>
        <h2>Add Income</h2>
        <input placeholder="amount" type="number" value={income.amount} onChange={e => setIncome({...income, amount: parseFloat(e.target.value)})} />
        <input placeholder="date" value={income.date || ''} onChange={e => setIncome({...income, date: e.target.value})} />
        <button onClick={() => post('/income', {amount: income.amount, date: income.date})}>Add</button>
      </div>
      <div>
        <h2>Add Liability</h2>
        <input placeholder="name" value={liability.name || ''} onChange={e => setLiability({...liability, name: e.target.value})} />
        <input placeholder="amount" type="number" value={liability.amount} onChange={e => setLiability({...liability, amount: parseFloat(e.target.value)})} />
        <button onClick={() => post('/liability', {name: liability.name, amount: liability.amount})}>Add</button>
      </div>
      <div>
        <h2>Add Credit Card Payment</h2>
        <input placeholder="card" value={card.cardName || ''} onChange={e => setCard({...card, cardName: e.target.value})} />
        <input placeholder="amount" type="number" value={card.amount} onChange={e => setCard({...card, amount: parseFloat(e.target.value)})} />
        <button onClick={() => post('/credit-card', {cardName: card.cardName, amount: card.amount})}>Add</button>
      </div>
      <div>
        <h2>Set Savings</h2>
        <input placeholder="amount" type="number" value={saving} onChange={e => setSaving(parseFloat(e.target.value))} />
        <button onClick={() => post('/savings', {amount: saving})}>Save</button>
      </div>
      <div>
        <button onClick={() => fetch(`${api}/summary`).then(r => r.json()).then(setSummary)}>Get Summary</button>
        {summary && (
          <pre>{JSON.stringify(summary, null, 2)}</pre>
        )}
      </div>
    </div>
  );
}

export default App;
