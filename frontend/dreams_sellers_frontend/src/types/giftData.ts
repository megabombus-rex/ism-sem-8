export interface GiftData {
    giftId: number,
    name: string,
    businessId: number,
    issuingVendorId: number,
    isService: boolean,
    giftDescription: string,
    costInPln: number,
    tags: string[],
    isArchived: boolean
}