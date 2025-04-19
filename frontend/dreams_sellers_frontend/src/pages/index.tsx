import { useState } from 'react';
import { useRouter } from 'next/router';
import { logEvent } from '../lib/logger';
import styles from '../styles/loginstyle'

export default function Home() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [userId, setUserId] = useState<number | null>(null);
  const router = useRouter();

  const handleLogin = async () => {
    logEvent('Attempting login');

    try {
      const response = await fetch('http://localhost:8080/api/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ email, password }),
      });

      if (!response.ok) throw new Error('Login failed');

      const result = await response.json(); // assuming the API returns: { userId: 123 }
      setUserId(result.userId);
      logEvent(`Login successful. User ID: ${result.userId}`);

      router.push('/dashboard');
    } catch (error) {
      logEvent('Login error: ' + (error as Error).message);
      alert('Login failed. Check console for details.');
    }
  };

  return (
    <main style={styles.container}>
      <div style={styles.form}>
        <input
          type="text"
          placeholder="Email"
          value={email}
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