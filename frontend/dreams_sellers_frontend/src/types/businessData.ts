export interface BusinessData {
    businessId: number;
    applicantId: number;
    name: string;
    email: string;
    phoneNumber: string;
    websiteUrl: string;
    isVerified: boolean;
    verificationTimestamp: string; // or Date if you plan to parse it
  }