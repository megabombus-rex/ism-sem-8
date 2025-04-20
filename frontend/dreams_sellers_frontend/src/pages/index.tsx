import { useEffect, useState } from 'react';
import { useRouter } from 'next/router';
import { logEvent } from '../lib/logger';
import styles from '../styles/loginstyle'

export default function Home() {
  const [emailAddress, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [userId, setUserId] = useState<number | null>(null);
  const router = useRouter();

  const handleLogin = async () => {
    logEvent('Attempting login');

    try {
      const response = await fetch('http://localhost:8080/auth/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ emailAddress, password, "role":"vendor" }),
      });

      if (!response.ok) throw new Error('Login failed');

      const result = await response.text(); // assuming the API returns: { userId: 123 }
      const resultParsed = Number(result);
      setUserId(resultParsed);
      logEvent(`Login successful. User ID: ${resultParsed}`);
      logEvent(`Login successful. Response text: ${result}`);
      
      localStorage.setItem('userId', resultParsed.toString());
      router.push('/dashboard');

    } catch (error) {
      logEvent('Login error: ' + (error as Error).message);
      alert('Login failed. Check console for details.');
    }
  };

  return (
    <main style={styles.container}>
      <div style={styles.form}>
        <text>Login as a vendor!</text>
        <input
          type="text"
          placeholder="Email"
          value={emailAddress}
          onChange={e => setEmail(e.target.value)}
          style={styles.input}
        />
        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={e => setPassword(e.target.value)}
          style={styles.input}
        />
        <button onClick={handleLogin} style={styles.button}>Login</button>
      </div>
    </main>
  );
}