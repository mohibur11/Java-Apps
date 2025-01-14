export function getFromLocalStorage<T>(key: string): T | null {
    const value = localStorage.getItem(key);
    if (value) {
        return JSON.parse(value) as T;
    }
    console.log("No such key found in the localStorage, returning null");
    
    return null;
}

export function setToLocalStorage<T>(key: string, value: T) {
    try {
        const stringValue = JSON.stringify(value);
        localStorage.setItem(key, stringValue);       
    } catch (error) {
        console.log("Set to localstorage us failed, this is the error object", error);
    }
}

export function removeFromLocalStorage(key: string) {
    localStorage.removeItem(key);
}
