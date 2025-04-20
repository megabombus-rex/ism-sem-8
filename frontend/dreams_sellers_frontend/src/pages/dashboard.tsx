import { useEffect, useState } from 'react';
import { useRouter } from 'next/router';
import { logEvent } from '../lib/logger';
import { BusinessData } from '@/types/businessData';
import styles from '@/styles/loginstyle';
import { GiftData } from '@/types/giftData';

export default function Dashboard() {
    const [userId, setUserId] = useState<number | null>(null);
    const [businessData, setBusinessData] = useState<BusinessData | null>(null);
    const [giftData, setGiftData] = useState<GiftData[]>([])
    

    const getBusinessData = async () => {
        logEvent('Getting vendor business data');
        
        try{
        const storedId = localStorage.getItem('userId');
        let userdd = 0;
        if (storedId) 
            logEvent('Stored id: ' + storedId.toString());
            userdd = Number(storedId);
            setUserId(userdd);

        logEvent('Getting data for user ' + userId?.toString());
        const response = await fetch('http://localhost:8080/vendors/' + userdd + '/business', {
            method: 'GET',
            headers: {
              'Content-Type': 'application/json',
            }
            
          });
        
        const data: BusinessData = await response.json();
        setBusinessData(data);
        }
        catch (error) {
            logEvent('Getting business error: ' + (error as Error).message);
            alert('Getting business failed. Check console for details.');
        }

    }

        
    const getBusinessGifts = async () => 
        {
            try
            {
                const response = await fetch('http://localhost:8080/gifts', {
                    method: 'GET',
                    headers: {
                      'Content-Type': 'application/json',
                    }
                    
                  });

                  //if (!response.ok) throw new Error('Login failed');

                  const data: GiftData[] = await response.json();
                  setGiftData(data);
            }
            catch (error) {
                logEvent('Getting gifts error: ' + (error as Error).message);
                alert('Getting gifts did not go well. Check console for details.');
            }
        }

    if (!businessData) return <div>
        <button onClick={getBusinessData} style={styles.button}>Get data</button>
        <p>Loading...</p>;
        </div>

    if (!giftData){
        return (
            <div style={{ padding: '2rem' }}>
              <div>
              <h2>Business Info</h2>
              <ul>
                <li><strong>ID:</strong> {businessData.businessId}</li>
                <li><strong>Applicant:</strong> {businessData.applicantId}</li>
                <li><strong>Name:</strong> {businessData.name}</li>
                <li><strong>Email:</strong> {businessData.email}</li>
                <li><strong>Phone:</strong> {businessData.phoneNumber}</li>
                <li><strong>Website:</strong> {businessData.websiteUrl}</li>
                <li><strong>Verified:</strong> {businessData.isVerified ? 'Yes' : 'No'}</li>
                <li><strong>Verified At:</strong> {new Date(businessData.verificationTimestamp).toLocaleString()}</li>
              </ul>
              </div>
              <button onClick={getBusinessGifts} style={styles.button}>Get gifts</button>
            </div>
          );
    }

    return (
        <div style={{ padding: '2rem' }}>
          <h2>Available Gifts</h2>
          {giftData.length === 0 ? (
            <div>
            <p>No gifts found.</p>
            <button onClick={getBusinessGifts} style={styles.button}>Get gifts</button>
            </div>
          ) : (
            <ul>
              {giftData.map((gift) => (
                <li key={gift.giftId}>
                  <h4>{gift.name}</h4>
                  <p>{gift.giftDescription}</p>
                  <p>💰 {gift.costInPln} PLN</p>
                  <p>🏷️ Tags: {gift.tags.join(', ')}</p>
                  <p>{gift.isService ? 'Service' : 'Product'}</p>
                  {gift.isArchived && <em>Archived</em>}
                  <hr />
                </li>
              ))}
            </ul>
          )}
        </div>
      );
}